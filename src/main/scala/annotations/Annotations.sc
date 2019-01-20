import scala.annotation.tailrec

// Like before annotations are there for meta data
class Thing(){
  @deprecated
  def doMine(): Unit ={

  }
}
// @deprecated
// @tailrec
// @inline
// @source
// @interface
// @SourceURL
// Note: Make sure you use the -target:jvm-1.8 option with Java annotations.
