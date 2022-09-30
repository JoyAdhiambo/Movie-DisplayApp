package com.example.moviesapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.moviesapp.R
import com.example.moviesapp.model.Movies

@Composable
fun MovieItems(
    movies : Movies
) {
    Card (
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxSize()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
            ){
      Surface() {
          Row(modifier = Modifier
              .padding(4.dp)
              .fillMaxSize()
          ) {
           Image(painter = rememberImagePainter(data = movies.imageUrl ,
           builder = {
               scale(Scale.FIT)
               placeholder(R.drawable.placeholder)
               transformations(CircleCropTransformation())
           })
               , contentDescription = movies.desc, modifier = Modifier
                   .fillMaxHeight()
                   .weight(0.2f),

           )
              Column(
                  verticalArrangement =Arrangement.Center,
              modifier = Modifier
                  .padding(4.dp)
                  .fillMaxHeight()
                  .weight(0.8f)

              ) {
                  Text(text = movies.name,
                  style = MaterialTheme.typography.subtitle1,
                      fontWeight = FontWeight.Bold
                  )

                Text(text = movies.category,
                    style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .background(
                        Color.LightGray
                    )
                    .padding(4.dp)
                    )


                  Text(text = movies.desc,
                      style = MaterialTheme.typography.body1,
                  overflow = TextOverflow.Ellipsis
                      )
              }

          }

        }

    }

}

@Composable
fun MovieList( movieList : List<Movies>) {
    LazyColumn {
        itemsIndexed(items = movieList){index, item ->
         MovieItems(movies = item)
        }
    }
    
}