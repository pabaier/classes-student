module FunWithStrings
  def palindrome?
    # your code here
    pal = self.downcase
    
    pal = pal.gsub(/[^a-zA-Z]/, "")
    pal == pal.reverse
    
    # pal.eql?(pal.reverse)
  end
  
  def count_words
    words = self.split(" ")
    count = {}
    
    words.each do |w|
      w.downcase!
      w = w.gsub(/[^a-zA-Z]/, "")
      next if w == ""
      if count[w] == nil
        count[w] = 1
      else
        count[w] = count[w] + 1
      end
    end
      
    return count
  end
  
  def anagram_groups
    word_list = self.split
    #puts "#{word_list}"
    anagram_list = []
    
    word_list.each do |word|
      word = word.gsub(/[^a-zA-Z]/, "")
      
      #sort the letters in the word
      pattern = word.chars.sort.join.downcase
      if anagram_list.assoc(pattern) == nil
        anagram_list << [pattern]
        anagram_list.last << word
      else
        anagram_list.assoc(pattern) << word
      end
    end
    
    anagram_list.each do |n|
      n.slice!(0)
    end
    
    anagram_list 
  end

end

# make all the above functions available as instance methods on Strings:

class String
  include FunWithStrings
end
