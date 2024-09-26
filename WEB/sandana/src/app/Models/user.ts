export class user{
    email:String
    passwd:String
    rol:String
    cartId:Number

    constructor(email:String, passwd:String,rol:String, cartId:Number){
        this.email = email
        this.passwd = passwd
        this.rol = rol
        this.cartId = cartId
    }
}