package eje1;

public class Main {

	public static void main(String[] args) {

		var  clima       = new cachedClima(new SujetoReal());

		long start       = System.currentTimeMillis();
		var  temperatura = clima.temperatura();
		long end         = System.currentTimeMillis();
		System.out.println((end - start) / 1000f);

		long start2       = System.currentTimeMillis();
		var  temperatura2 = clima.temperatura();
		long end2         = System.currentTimeMillis();
		System.out.println((end2 - start2) / 1000f);

		long start3       = System.currentTimeMillis();
		var  temperatura3 = clima.temperatura();
		long end3         = System.currentTimeMillis();
		System.out.println((end3 - start3) / 1000f);

	}

}
