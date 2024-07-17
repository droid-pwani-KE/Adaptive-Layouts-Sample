package com.droidpawani.dev.adaptivelayouts.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidpawani.dev.adaptivelayouts.R
import com.droidpawani.dev.adaptivelayouts.models.Pet
import com.droidpawani.dev.adaptivelayouts.ui.theme.AdaptiveLayoutsSampleTheme
import com.droidpawani.dev.adaptivelayouts.ui.theme.PetStoreTypography

@Preview(showBackground = true)
@Composable
fun PetsCardPortrait(
    pet: Pet = Pet(),
    onFavourite : () -> Unit = {},
    onPetSelected: () -> Unit = {}
) {
    Card(
        modifier = Modifier.wrapContentSize(),
        shape = RoundedCornerShape(10.dp),
        onClick = { onPetSelected() })
    {
        Column(
            modifier = Modifier
                .width(100.dp)
                .wrapContentHeight()
                .padding(4.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(80.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        Color.Gray
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.ic_pets),
                    contentDescription = "pet icon"
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth() ,
                verticalAlignment = Alignment.Top ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(0.5f) ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = pet.name ,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start ,
                        style = PetStoreTypography.headlineSmall
                    )
                    Text(
                        text = pet.breed ,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start ,
                        style = PetStoreTypography.bodySmall
                    )
                    Text(
                        text = "${pet.age} y/o" ,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start ,
                        style = PetStoreTypography.bodySmall
                    )
                }
                val icon = if(pet.isFavourite) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder
                Icon(
                    modifier = Modifier
                        .size(18.dp)
                        .clickable { onFavourite() } ,
                    imageVector = icon,
                    contentDescription = "favourite icon")

            }
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = "Ksh ${pet.price}" ,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start ,
                style = PetStoreTypography.headlineSmall
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun PetCardLandScape(
    pet: Pet = Pet(),
    onFavourite : () -> Unit = {},
    onPetSelected: () -> Unit = {}
){
    Card(
        modifier = Modifier.wrapContentSize(),
        shape = RoundedCornerShape(10.dp),
        onClick = { onPetSelected() })
    {
        Row(
            modifier = Modifier
                .widthIn(min = 150.dp, max = 250.dp)
                .wrapContentHeight()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){

            Box(
                modifier = Modifier
                    .width(70.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        Color.Gray
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.ic_pets),
                    contentDescription = "pet icon"
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            Column(
                Modifier
                    .width(100.dp)
                    .height(90.dp) ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        modifier = Modifier.weight(0.5f),
                        text = pet.name ,
                        textAlign = TextAlign.Start ,
                        style = PetStoreTypography.headlineSmall
                    )
                    val icon = if(pet.isFavourite) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder
                    Icon(
                        modifier = Modifier
                            .size(18.dp)
                            .clickable { onFavourite() } ,
                        imageVector = icon,
                        contentDescription = "favourite icon")

                }

                Text(
                    text = pet.breed ,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start ,
                    style = PetStoreTypography.bodySmall
                )
                Text(
                    text = "${pet.age} y/o" ,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start ,
                    style = PetStoreTypography.bodySmall
                )

                Text(
                    text = "Ksh ${pet.price}" ,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start ,
                    style = PetStoreTypography.headlineSmall
                )

                Row {
                    pet.temperament.forEach {
                        Box(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(2.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.Gray) ,
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "Ksh ${pet.price}" ,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start ,
                                style = PetStoreTypography.bodySmall,
                                fontSize = 6.sp
                            )
                        }
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetsCardPortraitPreview() {
    AdaptiveLayoutsSampleTheme {
        PetsCardPortrait()
    }
}