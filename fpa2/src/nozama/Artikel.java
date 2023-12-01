package nozama;

public class Artikel
{
	private String artikelbezeichnung;
	private int artikelnummer;
	private float preis;
	
	
	public Artikel(int artikelnummer, String artikelbezeichnung, float preis)
	{
		this.artikelnummer = artikelnummer;
		this.artikelbezeichnung = artikelbezeichnung;
		this.preis = preis;
	}
	
	
	public int getArtikelnummer()
	{
		return artikelnummer;
	}

	public void setArtikelnummer(int artikelnummer)
	{
		this.artikelnummer = artikelnummer;
	}

	public String getArtikelbezeichnung()
	{
		return artikelbezeichnung;
	}

	public void setArtikelbezeichnung(String artikelbezeichnung)
	{
		this.artikelbezeichnung = artikelbezeichnung;
	}

	public float getPreis()
	{
		return preis;
	}

	public void setPreis(float preis)
	{
		this.preis = preis;
	}


	@Override
	public String toString()
	{
		return artikelbezeichnung+ " / " + preis;//Ausgabe in List
	}

}
