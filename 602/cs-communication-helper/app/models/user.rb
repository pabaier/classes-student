class User < ActiveRecord::Base
  require 'csv'
  has_and_belongs_to_many :groups
  self.primary_key = "id"
  
  def self.all_students
      User.where(:status => ["Student", "Alumni"])
  end

  # a class method import, with file passed through as an argument
  def self.import(file)
    fields = User.column_names - ["id"]
    errors = []
    valid_users = []
    # fields.delete("id")
    # a block that runs through a loop in our CSV data
    CSV.foreach(file.path, headers: false) do |row|
      if row.length == fields.length then
        user_hash = Hash[fields.zip(row)]
        # creates a user for each row in the CSV file
        duplicate = User.where(:email => user_hash["email"])
        puts "*******************************"
        puts user_hash["email"]
        puts user_hash
        puts "*******************************"
        if duplicate.empty? then
          valid_user = User.create! user_hash
          valid_users << valid_user
        else
          errors << user_hash
        end
      else
        errors << row
      end
    end
    return [valid_users, errors]
  end 
    

   
   def authenticate(pass)
       @user = User.find(self.id)
       if(@user.password == pass)
           return true
       else
           return false
       end
   end
end