package br.com.larissamonteiro.todolistapi.config.validation;

public class ErrorValidationDto {

	private String field;
	private String erro;

	
	public ErrorValidationDto(String field, String erro) {
		this.field = field;
		this.erro = erro;
	}


	public String getField() {
		return field;
	}


	public String getErro() {
		return erro;
	}

	
}
