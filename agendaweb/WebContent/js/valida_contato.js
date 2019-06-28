const $ = (el) => document.querySelector(el);


let botao = $("#bt_cadastro_contato");


botao.addEventListener("click", function(){
	
	
	// FAZER UMA REFERÊNCIA AO FORM
	let formulario = $("#formulario_cadastro");
	
	// CRIAR UM OBJETO USUARIO
	let usuario = {
			nome:		formulario.querySelector("#nome").value,
			data:		formulario.querySelector("#dataNascimento").value,
			email:		formulario.querySelector("#email").value,
			telefone:	formulario.querySelector("#telefone").value,
			tipo:		formulario.querySelector("#tipo_combo").value,
			endereco:	formulario.querySelector("#endereco").value
	}
	
	// CRIAR VETOR QUE RECEBERÁ AS MENSAGENS
	let erros = validaUsuario(usuario);
	
	
	let ul = $("#lista_erros");
	ul.textContent = "";
	
	if(erros.length > 0){
		event.preventDefault();
		
		let divErro = $("#alerta_erro");
		divErro.classList.add("alert", "alert-warning");
		
		let p = document.createElement("p");
		p.textContent = "Ocorreram os seguintes erros:"
		ul.appendChild(p);
	
		for(let i = 0; i < erros.length; i++){
			let li = document.createElement("li");
			li.textContent = erros[i];
			ul.appendChild(li);
		}
	
	}
	
});

function validaUsuario(usuario){
	
	let erros = [];
	
	if(usuario.nome.length < 5){
		erros.push("O nome deve conter no mínimo 5 caracteres.");
		$("#nome").style.borderColor = "red";
	}else {
		$("#nome").style.borderColor = "green";
	}
	
	if(usuario.data == ""){
		erros.push("Deve selecionar uma data");
		$("#dataNascimento").style.borderColor = "red";
	}else {
		$("#dataNascimento").style.borderColor = "green";
	}
	
	if(usuario.email.length < 5){
		erros.push("O e-mail deve conter no mínimo 5 caracteres.")
		$("#email").style.borderColor = "red";
	}else {
		$("#email").style.borderColor = "green";
	}
	
	if(usuario.telefone.length < 8){
		erros.push("O telefone deve conter no mínimo 8 caracteres.")
		$("#telefone").style.borderColor = "red";
	}else {
		$("#telefone").style.borderColor = "green";
	}
	
	if(usuario.endereco.length < 8){
		erros.push("O endereço deve conter no mínimo 8 caracteres.")
		$("#endereco").style.borderColor = "red";
	}else {
		$("#endereco").style.borderColor = "green";
	}
	
	if(usuario.tipo == "SELECIONE"){
		erros.push("Selecione um tipo de contato.")
	}
	return erros;
}