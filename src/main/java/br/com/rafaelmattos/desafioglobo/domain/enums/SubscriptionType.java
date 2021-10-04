package br.com.rafaelmattos.desafioglobo.domain.enums;

public enum SubscriptionType {

	SUBSCRIPTION_PURCHASED(1, "Subscription Purchased"), 
	SUBSCRIPTION_CANCELED(2, "Subscription Canceled"),
	SUBSCRIPTION_RESTARTED(3, "Subscription Restarted");

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
