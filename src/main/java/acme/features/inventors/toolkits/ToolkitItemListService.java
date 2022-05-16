package acme.features.inventors.toolkits;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Toolkit;
import acme.entities.quantity.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service 
public class ToolkitItemListService implements AbstractListService<Inventor, Toolkit>{

    @Autowired
    protected InventorToolkitRepository repository;

    @Override
    public boolean authorise(final Request<Toolkit> request) {
        assert request != null; 

        return true; 
    }

    @Override
    public Collection<Toolkit> findMany(final Request<Toolkit> request) {
        final Collection<Toolkit> result = new HashSet<>();
        int toolkitId;

        toolkitId = request.getModel().getInteger("id");
        final Collection<Quantity> quantities = this.repository.findManyQuantitiesByToolkitId(toolkitId);

        for(final Quantity quantity: quantities) {
            final int id=quantity.getId();
            final Collection<Toolkit> items=this.repository.findManyItemsByQuantityId(id);
            result.addAll(items);
        }

        return result;
    }

    @Override
    public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
        assert request != null; 
        assert entity != null; 
        assert model != null; 

        request.unbind(entity, model, "itemType", "name","code", "technology", "retailPrice"); 

    }

}