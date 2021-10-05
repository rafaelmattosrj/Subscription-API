package br.com.rafaelmattos.desafioglobo.domain.enums;

public enum SubscriptionType {

	SUBSCRIPTION_PURCHASED(1, "SUBSCRIPTION PURCHASED"), 
	SUBSCRIPTION_CANCELED(2, "SUBSCRIPTION CANCELED"),
	SUBSCRIPTION_RESTARTED(3, "SUBSCRIPTION RESTARTED");

	private int cod;
	private String description;

	private SubscriptionType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static SubscriptionType toEnum(Integer type) {

		if (type == null) {
			return null;
		}

		for (SubscriptionType x : SubscriptionType.values()) {
			if (type.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + type);
	}

}
