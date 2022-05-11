class Group < ActiveRecord::Base
    has_and_belongs_to_many :users
    
    #Might need later
    #def self.all_groups
    #    Group.all
    #end

end
