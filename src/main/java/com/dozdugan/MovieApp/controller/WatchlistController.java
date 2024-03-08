package com.dozdugan.MovieApp.controller;

import com.dozdugan.MovieApp.dto.request.WatchlistRequest;
import com.dozdugan.MovieApp.model.WatchList;
import com.dozdugan.MovieApp.service.WatchlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/watchlists")
public class WatchlistController {

    private final WatchlistService watchlistService;

    @GetMapping()
    public List<WatchList> getAll(){
       return watchlistService.getAllWatchlist();
   }

    @GetMapping("/{id}")
    public WatchList getWatchlistById(@PathVariable Long id){
        return watchlistService.getWatchlistById(id);
    }

    @PostMapping("/{id}")
    public String createWatchlist(@PathVariable Long id, @RequestBody WatchlistRequest watchlistRequest){
     return watchlistService.createWatchlist(id,watchlistRequest);
   }

   @DeleteMapping("/{id}")
   public String deleteWatchlist(@PathVariable Long id){
            return watchlistService.deleteWatchlist(id);
        }

   @PutMapping("/{id}")
   public String updateWatchlist(@PathVariable Long id, @RequestBody WatchlistRequest watchlistRequest){
     return watchlistService.updateWatchlist(id,watchlistRequest);
    }

   @PostMapping("/{watchlistId}/{movieId}")
   public String addMovieToWatchlist(@PathVariable Long watchlistId,@PathVariable Long movieId){
        return watchlistService.addMovieToWatchList(watchlistId,movieId);
    }
}
