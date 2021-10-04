package br.com.rafaelmattos.desafioglobo.domain.enums;

public enum SubscriptionType {

	SUBSCRIPTION_PURCHASED(1, "Ubscription Purchased"), 
	SUBSCRIPTION_CANCELED(2, "Subscription Canceled"),
	SUBSCRIPTION_RESTARTED(3, "Subscription Restarted");

	private int cod;
	private String descricao;

	private SubscriptionType(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static SubscriptionType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (SubscriptionType x : SubscriptionType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
