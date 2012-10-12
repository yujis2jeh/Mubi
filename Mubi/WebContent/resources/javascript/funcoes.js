function desabilitarBotaoCamposPreenchidos() {
	var idForm = "incluirFilmeForm";
	var botao = document.getElementById(idForm + ":btnProximo");
	var tituloBr = document.getElementById(idForm + ":tituloBrasil").value;
	var tituloOriginal = document.getElementById(idForm + ":tituloOriginal").value;
	var ano = document.getElementById(idForm + ":ano").value;
	var duracao = document.getElementById(idForm + ":duracao").value;
	//var classificacao = document.getElementById(idForm + ":classificacao").value;
	var estudio = document.getElementById(idForm + ":estudio").value;
	var direcao = document.getElementById(idForm + ":direcao").value;
	
	if(tituloBr != ""  && tituloOriginal != "" && ano != "" && duracao != "" 
			//&& classificacao != ""
				&& estudio != "" && direcao != ""){
		botao.disable();
	} else {
		botao.enable();
	}
}

function habilitarComboCategoria(objRadio) {
	var radioSelecionado = objRadio.value;
	
	if(radioSelecionado == 3) {
		document.getElementById("principalForm:comboCategoria").rendered = true;
		document.getElementById("principalForm:pesquisa").disabled = true;
	} else {
		document.getElementById("principalForm:comboCategoria").rendered = false;
		document.getElementById("principalForm:pesquisa").disabled = false;
	}
}