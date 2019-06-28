const $ = (el) => document.querySelector(el);


let botao = $("#bt_criar_usuario");


botao.addEventListener("click", function(){
	
	// FAZER UMA REFERÊNCIA AO FORM
	let formulario = $("#formulario_cadastro");
	
	// CRIAR UM OBJETO USUARIO
	let usuario = {
			nome:		formulario.querySelector("#nome").value,
			email:		formulario.querySelector("#email").value,
			senha:		formulario.querySelector("#senha").value,
			confSenha:	formulario.querySelector("#conf_senha").value
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
	
	if(usuario.email.length < 5){
		erros.push("O e-mail deve conter no mínimo 5 caracteres.")
		$("#email").style.borderColor = "red";
	}else {
		$("#email").style.borderColor = "green";
	}
	
	if(usuario.senha.length < 8){
		erros.push("O senha deve conter no mínimo 8 caracteres.")
		$("#senha").style.borderColor = "red";
	}else {
		$("#senha").style.borderColor = "green";
	}
	
	if(usuario.confSenha.length < 8){
		erros.push("A confirmação da senha deve conter no mínimo 8 caracteres.")
		$("#conf_senha").style.borderColor = "red";
	}else {
		$("#conf_senha").style.borderColor = "green";
	}
	
	if(usuario.senha != usuario.confSenha){
		erros.push("As senhas não conferem.")
	}
	
	return erros;
}