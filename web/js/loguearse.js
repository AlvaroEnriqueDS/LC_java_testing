var datas;
var vm = new Vue({
    el:'#logueovue',
    data:{
        nombre:'s',
        correo:"",
        contraseña:'',
    },
    methods:{
        sendForm: function (e) {
            axios.post('/Perfil/login', {
                correo : this.correo,
                contrasena: this.contraseña
            })
                .then(function (response) {
                    console.log(response);
                    console.log(response.data.nombre);
                    datas = response;

                    this.nombre=response.data.nombre;
                    this.nombre="dsdasdas"
                    console.log(this.nombre);
                    if (response.data.nombre!==undefined){
                        localStorage.estadoSesion="on";
                    }
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})