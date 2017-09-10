class Dessert
  def initialize(name, calories)
    @name = name
    @calories = calories
  end
  attr_accessor :name, :calories
  
  def healthy?
    calories < 200
  end
  def delicious?
    true
  end
end

class JellyBean < Dessert
  def initialize(flavor)
    @flavor = flavor.downcase
    super(@flavor + " jelly bean", 5)
  end
  
  attr_accessor :flavor
  
  def delicious?
    if @flavor == "licorice"
      return false
    end
    super
  end
  
end