package Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "PAZIENTE")
public class Paziente {

	    @Id
	    private String id;

	    @Field(name="NOME")
	    private String nome;

	    @Field(name="COGNOME")
	    private String cognome;

	    @Field(name="CODICE_FISCALE")
	    private String codiceFiscale;

	    @Field(name="DATA_DI_NASCITA")
	    private String dataDiNascita;

	    @Field(name="SESSO")
	    private String sesso;

	    @Field(name="INDIRIZZO")
	    private String indirizzo;

	    @Field(name="NUMERO_DI_CELLULARE")
	    private String numeroDiCellulare;

	    @Field(name="DENTISTA_ID") //foreign key
	    private String dentistaId;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getCodiceFiscale() {
			return codiceFiscale;
		}

		public void setCodiceFiscale(String codiceFiscale) {
			this.codiceFiscale = codiceFiscale;
		}

		public String getDataDiNascita() {
			return dataDiNascita;
		}

		public void setDataDiNascita(String dataDiNascita) {
			this.dataDiNascita = dataDiNascita;
		}

		public String getSesso() {
			return sesso;
		}

		public void setSesso(String sesso) {
			this.sesso = sesso;
		}

		public String getIndirizzo() {
			return indirizzo;
		}

		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}

		public String getNumeroDiCellulare() {
			return numeroDiCellulare;
		}

		public void setNumeroDiCellulare(String numeroDiCellulare) {
			this.numeroDiCellulare = numeroDiCellulare;
		}

		public String getDentistaId() {
			return dentistaId;
		}

		public void setDentistaId(String dentistaId) {
			this.dentistaId = dentistaId;
		}


}
