export class article{
    
    id:Number
    description:String
    model:String
    size:String
    color:String
    stock:String

    constructor(id:Number, description:String, model:String, size:String, color:String, stock:String) {
        this.id = id
        this.description = description
        this.model = model
        this.size = size
        this.color = color
        this.stock = stock
    }
}