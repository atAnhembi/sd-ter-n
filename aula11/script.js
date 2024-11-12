const txtCod = document.getElementById("cod")
const txtName = document.getElementById("name")
const txtValue = document.getElementById("value")
const txtResposta = document.getElementById("resposta")
const btnBuscar = document.getElementById("btn_buscar")
const btnCadastrar = document.getElementById("btn_cadastrar")
const btnApagar = document.getElementById("btn_apagar")

const url = "http://localhost:8080/product";

async function buscar() {
    let resposta =  await fetch(url + "/" + txtCod.value);

    if(resposta.status == 200) {
        let dados = await resposta.json();
        txtName.value = dados["name"] 
        txtValue.value = dados["value"] 
        txtResposta.innerHTML = "Produto encontrado!"
    } else {
        txtResposta.innerHTML = "Produto não encontrado!"
    }
}

async function cadastrar() {
    let resposta =  await fetch(url,{
        method: "POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            "name": txtName.value,
            "value": txtValue.value
        })
    });

    if(resposta.status == 201) {
        let dados = await resposta.json();
        txtCod.value = dados["cod"]
        txtName.value = dados["name"] 
        txtValue.value = dados["value"] 
        txtResposta.innerHTML = "Produto cadastrado!"
    } else {
        txtResposta.innerHTML = "Erro ao cadastrar!"
    }
}

async function apagar() {
    let resposta =  await fetch(url + "/" + txtCod.value,
    {
        method: "DELETE",
        headers:{
            "Content-Type":"application/json"
        },
    });

    if(resposta.status == 204) {
        txtResposta.innerHTML = "Produto APAGADO!"
    } else {
        txtResposta.innerHTML = "Erro ao apagar!"
    }
}

btnBuscar.addEventListener('click', buscar)
btnCadastrar.addEventListener('click', cadastrar)
btnApagar.addEventListener('click', apagar)