class RockPaperScissors

  # Exceptions this class can raise:
  class NoSuchStrategyError < StandardError
    def initialize(msg = "Strategy must be one of R,P,S")
      super
    end
  end

  def self.winner(player1, player2)
    raise NoSuchStrategyError unless 
      player2[1] =~ /[RPS]/ and player1[1] =~ /[RPS]/

    # if player1[1] =~ /[^RPS]/
    #   raise NoSuchStrategyError #"Strategy must be one of R,P,S."
    # end
      
    p1_win = [["R", "R"], ["P", "P"], ["S", "S"], ["R", "S"], ["S", "P"], ["P", "R"]]
    game = [player1[1], player2[1]]
 
    p1_win.each do |check|
      if check == game
        return player1
      end
    end
    return player2
  end

  def self.tournament_winner(tournament)
    if tournament[0][0].is_a? String
      return RockPaperScissors.winner(tournament[0], tournament[1])
    else
      return RockPaperScissors.winner(self.tournament_winner(tournament[0]), 
                                      self.tournament_winner(tournament[1]))
    end
  end

end
