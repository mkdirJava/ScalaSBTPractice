class Container (var name:String){
  private var itemMap:Map[Int,Item] = Map.empty
  private var idCounter:Int =0

  case class Item(id:Int){
    private var _itemList:List[Item] = Nil

    def addToList(item:Item):Unit = {
      if(!_itemList.contains(item))
        _itemList = item ::_itemList

    }

    def getItemList() = _itemList


  }

  def create() = {
    var item = Item(idCounter)
    itemMap = itemMap + (idCounter -> item)
    idCounter+=1
    item
  }


}

val container:Container = new Container("Mine")
val valueOne = container.create()
val valueTwo = container.create()
val valueThree = container.create()

valueOne.addToList(valueTwo)
println(valueOne.getItemList())