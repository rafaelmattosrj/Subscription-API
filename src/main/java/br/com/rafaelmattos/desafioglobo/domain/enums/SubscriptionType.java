package br.com.rafaelmattos.desafioglobo.domain.enums;

public enum SubscriptionType {

	SUBSCRIPTION_PURCHASED(1, "SUBSCRIPTION PURCHASED"),
	SUBSCRIPTION_CANCELED(2, "SUBSCRIPTION CANCELED"),
	SUBSCRIPTION_RESTARTED(3, "SUBSCRIPTION RESTARTED");

	private final int cod;
	private final String type;

	SubscriptionType(Integer cod, String type) {
		this.cod = cod;
		this.type = type;
	}

	public int getCod() {
		return cod;
	}

	public String getType() {
		return type;
	}

	public static SubscriptionType toEnum(String type) {

		if (type == null) {
			return null;
		}

		for (SubscriptionType x : SubscriptionType.values()) {
			if (type.equals(x.getType())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + type);
	}

}
