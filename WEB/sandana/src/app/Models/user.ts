export class User{
    email:string
    passwd:String
    rol:String

    constructor(email:string, passwd:String,rol:String){
        this.email = email
        this.passwd = passwd
        this.rol = rol
    }
}