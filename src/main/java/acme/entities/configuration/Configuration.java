package acme.entities.configuration;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Configuration extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;
	
	// Attributes -------------------------------------------------------------

				//SystemCurrency(String) //Falta añadir filtro 3 letrasMayusculas
				@NotBlank
				@Pattern(regexp = "")
				private String sysCurrency;
				
				
				//AllowedCurrencies(String) //Falta añadir filtro 3 letrasMayusculas
				@NotBlank
				@Pattern(regexp = "")
				private String allowedCurrencies;
				
				
				//StrongSpamWords(String)
				@NotBlank
				private String StrongSpam;
				
				
				//WeakSpamWords(String)
				@NotBlank
				private String weakSpam;
							
				
				//StrongSpamThreshold
				@Min(0)
				@Max(1)
				private double strongThreshold;
					
				
				//WeakSpamThreshold
				@Min(0)
				@Max(1)
				private double weakThreshold;
				
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	@NotBlank
	String						spamWords;

	@NotNull
	@Range(min = 0, max = 1)
	private Double				spamThreshold;


	public boolean isSpam(final String text) {
		final String[] lowerCaseText = text.toLowerCase().split(" ");
		int spamCount = 0;
		final String[] sp = this.spamWords.split(",");

		for (final String s : sp) {
			if (text.toLowerCase().trim().replaceAll("\\s+", " ").contains(s)) {
				spamCount++;
			}
			for (int i = 0; i < lowerCaseText.length; i++) {
				if (lowerCaseText[i].contains(s)) {
					spamCount++;
				}

			}
		}
		if (spamCount % 2 == 0) {
			spamCount = spamCount / 2;
		} else {
			spamCount = (spamCount / 2) + 1;
		}
		final Double umbral = (double) spamCount / lowerCaseText.length;

		return umbral > this.spamThreshold;

	}
	**/
}
