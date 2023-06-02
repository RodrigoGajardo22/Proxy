package eje1;

import java.time.LocalDateTime;

//Esta seria la clase proxy

public class cachedClima implements Sujeto {

	private Sujeto        sujetoReal;
	private String        cachedTemperatura;
	private LocalDateTime cachedTime;

	public cachedClima(Sujeto sujetoReal) {
		this.sujetoReal = sujetoReal;
		this.cachedTime = LocalDateTime.now();
	}

	@Override
	public String pronostico() {

		return this.sujetoReal.pronostico();
	}

	@Override
	public String temperatura() {
		if (cachedTemperatura != null && LocalDateTime.now().isBefore(cachedTime.plusMinutes(30))) {
			return cachedTemperatura;
		}

		this.cachedTemperatura = this.sujetoReal.temperatura();

		return this.cachedTemperatura;
	}

}
