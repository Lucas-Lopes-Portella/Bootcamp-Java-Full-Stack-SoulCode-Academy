var janelaLogin = new bootstrap.Modal(document.getElementById("loginNegado"));
var loginBranco = new bootstrap.Modal(document.getElementById("campoBranco"));
var janelaPromocao = new bootstrap.Modal(document.getElementById("promo1"));
var janelaPromocao2 = new bootstrap.Modal(document.getElementById("promo2"));
var allusersinfo = new bootstrap.Modal(document.getElementById("allusersinfo-el"));
var attemptstext = document.querySelector("#attempts");
var v1 = document.getElementById("v1");
var userLogin = [
  {
    id:1001 ,
    email: 'adminUsers' ,
    senha: 'goodpay2022' ,
  },
  {
    id:1002 ,
    username: 'victoricoma' ,
    senha: 'gordinho123' ,
    email: 'victor.icoma@soulcodeacademy.org',
  },
  {
    id:1003 ,
    username: 'marcelofarofa' ,
    senha: 'ff123456' ,
    email: 'marceloff@gmail.com',
  },
  {
    id:1004 ,
    username: 'superRotas',
    senha: 'goodpayrotas',
    email: 'goodpayadmin@soulcode.org',
  }
];

var resultcaptcha
function generatorCaptcha() {
  let captcha1 = Math.floor(Math.random() * 100 + 10);
  let captcha2 = Math.floor(Math.random() * 10);
  let sum = captcha1 + captcha2;
  resultcaptcha = [captcha1, captcha2, sum];
  return v1.innerText = `: ${captcha1} + ${captcha2} =`
}
function loginInfo(email, senha, recaptcha) {
  localStorage.clear()
  var userInfo = userLogin.find(userLogin => userLogin.email === email && userLogin.senha === senha && resultcaptcha[2] == recaptcha)
  if (userInfo !== undefined) {
    return true
  }
}
function rotaCadastro() {
  window.location.href = "../registro.html";
}
function rotaRecuperar() {
  window.location.href = "../recuperar.html";
}
var attemptscaptcha = 1
function rotaLogin() {
  let email = document.getElementById("email").value;
  let senha = document.getElementById("senha").value;
  let recaptcha = document.querySelector('#recaptcha').value
  if (email === "" || senha === "") {
    loginBranco.show()
  } else if (email !== "" && senha !== "") {
    if (loginInfo(email, senha, recaptcha) === true) {
      if (email === "adminUsers" && senha === "goodpay2022") {
        showAllUsers()
      } else {
        window.location.href = "../index.html";
      }
    } else if (attemptscaptcha <= 3) {
      attemptstext.innerText = `${attemptscaptcha}ª tentativa. Após 3 tentativas você será redirecionado(a) para recuperar senha.`
      janelaLogin.show();
      attemptscaptcha++;
    } else if (attemptscaptcha > 3) {
      rotaRecuperar();
    }
  }
}
function showAllUsers() {
  allusersinfo.show()
  let usersinfoshow = document.querySelector(".allusers")
  userLogin.forEach((user) => {
    if (user.email !== "adminUsers") {
      usersinfoshow.innerHTML += `<p>id:${user.id}</p>
      <p>Username:${user.username}</p><p>Senha: ${user.senha}</p><p>Email: ${user.email}</p><hr>`
    }
  })
}
function alertaPromo() {
  let titulo = "Pequenos Pecados";
  let corpo = "<h6>Lazer e Qualidade de Vida!</h6><p><img src='./img/7.png' height='160'></p>";

  janelaPromocao.show();

  document.getElementById("titulo").innerHTML = titulo;
  document.getElementById("corpo").innerHTML = corpo;
}
document.addEventListener("DOMContentLoaded", function(){
  var element = document.getElementById("liveToast");
  var myToast = new bootstrap.Toast(element);
  myToast.show();
});

function alertaPromo2() {
  let titulo2 = "GoodPay no Cash Back";
let corpo2 = "<p><img src='./img/9.png' height='160'></p><h6>Todas as compras a vista que não são vinculadas ao seu especial podem render bilhetes para sorteios. Economize 250 no mês e faça compras no cartão de débito sem usar o especial ao final terá bilhetes que podem render desde um voucher de sanduba até 8x seu porquinho.</h6>";

  janelaPromocao2.show();

  document.getElementById("titulo2").innerHTML = titulo2;
  document.getElementById("corpo2").innerHTML = corpo2;
}

function darkMode() {
  var element = document.body;
  element.classList.toggle("dark-mode");
}

/* REGISTRO */

/* 
I) Password
 */
function passw_Registro() {
  var senha = document.getElementById('senha1_Registro');
  if (senha.type == "password") {
    senha.type = "text";
  } else {
    senha.type = "password"
  }


}
function passw2_Registro() {
  var senha = document.getElementById('senha2_Registro');
  console.log(senha)

  if (senha.type == "password") {
    senha.type = "text";
  } else {
    senha.type = "password"
  }
}

/* Verificar compatibilidade */

function compatibilidade_Registro() {
  var a = document.getElementById("senha1_Registro")
  var b = document.getElementById("senha2_Registro")


  b.style.backgroundColor = "white";
  b.style.border = "2px solid red";


  if ((a.value) == (b.value)) {
    b.style.border = "2px solid green";
  }
  console.log(a.value)
  console.log(b.value)

}

/* Confirmar senha */
function confirmarSenha_Registro() {
  var a = document.getElementById("senha1_Registro");
  var b = document.getElementById("senha2_Registro");
  var c = document.getElementById("btn_Registro");
  var d = document.getElementById("form_Registro");

  if (a.value != b.value) {
    alert("Senha incorreta!")

  } else {

    alert("Cadastro realizado com sucesso!");
    d.action = 'app.html';
    c.type = 'submit';
    console.log(c)
    console.log(d);

  }

}