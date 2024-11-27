export class Article{
    
    id:Number
    description:String
    model:String
    size:String
    color:String
    stock:String
    gender:String
    pvp:number

    constructor(id:Number, description:String, model:String, size:String, color:String, stock:String, gender:String, pvp:number) {
        this.id = id
        this.description = description
        this.model = model
        this.size = size
        this.color = color
        this.stock = stock
        this.gender = gender
        this.pvp = pvp
    }
}