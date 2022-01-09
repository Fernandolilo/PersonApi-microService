package com.systempro.person.enums;

public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"), CLIENT(2, "ROLE_CLIENT");

	private int cod;
	private String description;

	// atribui o cod e descrição criados para efetuar o tipo de cliente
	private Perfil(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static Perfil toEnum(Integer cod) {
		// proteção caso o cod seja nulo retorna nulo também
		if (cod == null) {
			return null;
		}

		//esta percorrendo o tipo cliente , TipoCliente.values são todos os codigos possiveis
		for (Perfil x : Perfil.values()) {
			/* estamos testando se o cod for igual a x.getCod, 
			 * retorna um codigo x seja ele Admin ou Client
			 */ 
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
