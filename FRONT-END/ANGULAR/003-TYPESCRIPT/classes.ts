class Pessoa {
    constructor(
        private nome: string,
        public email: string,
        protected senha: string | number
    ) { }

    cumprimentar(num: number): void {
        console.log(`Olá, meu nome é ${this.nome} e eu tenho ${num} anos`)
    }

    cumprimentarComRetorno(): string {
        return `Olá, meu nome é ${this.nome}`
    }

}

let p: Pessoa = new Pessoa('Mario', 'pedro@email.com', 12345678)

console.log(p.cumprimentarComRetorno())
p.cumprimentar(20) 










/* class Pessoa {
    
    public nome: string
    public email: string
    public senha: string | number

    public  constructor(nome: string, email: string, senha: string | number) {
        this.nome = nome
        this.email = email
        this.senha = senha
    }

    cumprimentar(num: number): void {
        console.log(`Olá, meu nome é ${this.nome} e eu tenho ${num} anos`)
    }

    cumprimentarComRetorno(): string {
        return `Olá, meu nome é ${this.nome}`
    }
}

let p: Pessoa = new Pessoa('Mario', 'pedro@email.com', 12345678)

console.log(p.cumprimentarComRetorno())
p.cumprimentar(20)  */