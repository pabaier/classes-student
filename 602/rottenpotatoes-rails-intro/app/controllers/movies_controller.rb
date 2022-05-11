class MoviesController < ApplicationController

  # See Section 4.5: Strong Parameters below for an explanation of this method:
  # http://guides.rubyonrails.org/action_controller_overview.html
  def movie_params
    params.require(:movie).permit(:title, :rating, :description, :release_date)
  end

  def show
    id = params[:id] # retrieve movie ID from URI route
    @movie = Movie.find(id) # look up movie by unique ID
    # will render app/views/movies/show.<extension> by default
  end

  def index
    sort = params[:sort] || session[:sort]
    @all_ratings = Movie.all_ratings # string array of ratings
    @rating_hash = params[:ratings] || session[:ratings] || {}

    # if params[:ratings] == nil
    #   @rating_keys = @all_ratings
    # else
    #   @rating_keys = params[:ratings].keys # array of strings
    # end
        
    # if @rating_hash == {}
    #   @rating_hash = Hash[@all_ratings.map{|rating| [rating, rating]}]
    # end
    
    if @rating_hash == {}
      @rating_hash = Hash[@all_ratings.map {|rating| [rating, rating]}]
    end
    
    if params[:sort] != session[:sort] or params[:ratings] != session[:ratings]
      session[:sort] = sort
      session[:ratings] = @rating_hash
      flash.keep
      redirect_to :sort => sort, :ratings => @rating_hash and return
    end
    
    if sort == 'title'
      ordering = {:title => :asc}
      @title_header = 'hilite'
    elsif sort == 'release_date'
      ordering = {:release_date => :asc}
      @release_header = 'hilite'
    end
    
    #@movies = Movie.order(ordering)
    @movies = Movie.where(rating: @rating_hash.keys).order(ordering)
    
    
    
  end

  def new
    # default: render 'new' template
  end

  def create
    @movie = Movie.create!(movie_params)
    flash[:notice] = "#{@movie.title} was successfully created."
    redirect_to movies_path
  end

  def edit
    @movie = Movie.find params[:id]
  end

  def update
    @movie = Movie.find params[:id]
    @movie.update_attributes!(movie_params)
    flash[:notice] = "#{@movie.title} was successfully updated."
    redirect_to movie_path(@movie)
  end

  def destroy
    @movie = Movie.find(params[:id])
    @movie.destroy
    flash[:notice] = "Movie '#{@movie.title}' deleted."
    redirect_to movies_path
  end

  private :movie_params
  
end
