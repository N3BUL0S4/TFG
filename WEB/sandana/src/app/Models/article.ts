export class article{
    
    id:Number
    description:String
    model:String
    size:String
    color:String
    stock:String
    gender:String
    pvp:Number

    constructor(id:Number, description:String, model:String, size:String, color:String, stock:String, gender:String, pvp:Number) {
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