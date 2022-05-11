When("I choose the delimiter {string}") do |string|
  select(string, from: "delimiter").select_option
end
