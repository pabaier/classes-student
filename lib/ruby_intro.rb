# When done, submit this entire file to the autograder.

# Part 1

def sum arr
  total = 0
  if arr.empty?
    return total
  else
    arr.each do |x|
      total += x
    end
  end
  total
end

def max_2_sum arr
  if arr.empty?
    return 0
  end
  
  if arr.length == 1
    return arr[0]
  end
  
  max = arr[0]
  second = arr[1]
  
  arr[1..-1].each do |x|
    if x > max
      second = max
      max = x
    elsif x >= second
      second = x
    end
  end
  
  return max + second
  
end

def sum_to_n? arr, n
  arr.permutation(2) do |x,y|
    if x + y == n
      return true
    end
  end
  
  false
  
end

# Part 2

def hello(name)
  "Hello, " + name
end

def starts_with_consonant? s
  if s.empty?
    return false
  end
  
  s.downcase!
  s[0] =~ /[bcdfghjklmnpqrstvwxyz]/
  
  # Non-Ruby-Like Code
  # start = "bcdfghjklmnpqrstvwxyz"
  # start.each_char { |x|
  #   if s.start_with?(x)
  #     return true
  #   end
  # }
  # return false
end

def binary_multiple_of_4? s
  if s == "0"
    return true
  end
  
  if s =~ /[^01]/
    return false
  end
  
  s =~ /00$/
  
  # Non-Ruby-Like Code
  # binary = s.to_i(2)
  # if binary == 0
  #   return false
  # end
  
  # binary % 4 == 0

end

# Part 3

class BookInStock
  
  def initialize(i, p)
    if i.empty? || p <= 0
      raise ArgumentError
    end
    
    @isbn = i
    @price = p.round(2)
  end
  
  attr_accessor :isbn, :price
  
  def price_as_string
    string_price = @price.to_s
    if(string_price =~ /(.*)\.(.{2})$/)
      return "$#{string_price}"
    elsif string_price =~ /(.*)\.(.{1})$/
      return "$#{string_price}0"
    else
      return "$#{string_price}.00"
    end
  end
  
end