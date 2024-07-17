package com.droidpawani.dev.adaptivelayouts.data.repository.impl

import com.droidpawani.dev.adaptivelayouts.data.repository.PetsRepository
import com.droidpawani.dev.adaptivelayouts.models.PetsFilter
import com.droidpawani.dev.adaptivelayouts.models.Pet
import com.droidpawani.dev.adaptivelayouts.utils.extensions.addOrRemove
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update

class FakePetsRepository : PetsRepository {

    private val pets by lazy {
        listOf(
            Pet(
                id = "23iuncenyegg",
                breed = "Airedale Terrier",
                description = "The Airedale Terrier is the largest of all terrier breeds. The breed is tall and sturdy with a muscular body and covered in a thick, course coat of fur.\n" +
                        "\n" +
                        "Airedale Terriers are known for their heavy shedding and need a high level of grooming compared to many other breeds. Originating in England in the 1800s, the Airedale Terrier was developed by cross breeding a Terrier with an Otterhound, although it is suspected that there are other breeds in the mix. It is widely believed that the old Black and Tan Terrier, together with the Broken Coated Terrier were probably used.",
                image = "",
                price = 55000.00,
                age = 2,
                weight = 9.6,
                color = "Brown",
                healthRisk = "High probability of health issues during its lifetime, hence it is one of the more expensive breeds to insure",
                temperament = listOf("Intelligent", "Loyal")
            ),
            Pet(
                id = "8rbriusdbk2",
                breed = "Alaskan Husky",
                description = "Originating from the crossbreeding of multiple other breeds, the Alaskan Husky is a type, rather than a breed, of dog, and is not recognised as a breed anywhere in the world. Technically, all breeds of highly efficient sled dogs are Alaskan Huskies. The original Alaskan Huskies were developed by mushers – people who ride in a sled behind a team of sled dogs – from the different lineages of native Inuit dogs.",
                image = "",
                price = 40000.00,
                age = 1,
                weight = 15.1,
                color = "White",
                healthRisk = "This breed has an average probability of having health issues in its lifetime, hence it is one of the more affordable breeds to insure.",
                temperament = listOf("Energetic", "Friendly", "Affectionate")
            ),
            Pet(
                id = "3gfv44bffer",
                breed = "Beagle",
                description = "Modern Beagles have their roots in Essex, England in the 1830’s, where they were bred by Reverend Phillip Honeywood, primarily for the purpose of tracking game. A mix of a number of different breeds, including the Southern Hound, the North Country Beagle and the Talbot Hound, Beagles excelled as trackers because they have a great nose for sniffing out rabbits, hares and deer.",
                image = "",
                price = 250000.00,
                age = 2,
                weight = 8.5,
                color = "White-Brown",
                healthRisk = "This breed has an around average probability of having health issues in its lifetime, hence it is one of the more affordable breeds to insure.",
                temperament = listOf("Gentle", "Reliable", "Loyal")
            ),

            Pet(
                id = "6djadsajhd8",
                breed = "BoerBoel",
                description = "The Boerboel is a very large, strong and muscular domesticated working dog. Loyal to a fault, the Boerboel is a tough breed that was developed to guard the homestead in hard African conditions.",
                image = "",
                price = 38000.00,
                age = 3,
                weight = 14.8,
                color = "Brown",
                healthRisk = "This breed has an around average probability of having health issues in its lifetime, hence it is one of the more affordable breeds to insure.",
                temperament = listOf("Confident", "Calm", "Loyal")
            ),
            Pet(
                id = "7ednad9e8edf",
                breed = "Border Collie",
                description = "Border Collies are extremely smart and energetic working dogs that have become popular family pets. They require considerable physical and mental stimulation.",
                image = "",
                price = 20000.00,
                age = 6,
                weight = 10.9,
                color = "White-Black",
                healthRisk = "This breed has an around average probability of having health issues in its lifetime, hence it is one of the more affordable breeds to insure.",
                temperament = listOf("Obedient", "Affectionate", "Friendly")
            ),
            Pet(
                id = "45uabdad88",
                breed = "Chihuahua",
                description = "Chihuahuas are cute and energetic tiny size dogs that are fiercely devoted to their owners but can be snappy or reserved towards strangers. They have a lot of personality and a big dog attitude.",
                image = "",
                price = 18000.00,
                age = 1,
                weight = 5.8,
                color = "Black",
                healthRisk = "This breed is in the lower risk category for developing health issues, hence it is one of the most affordable breeds to insure.",
                temperament = listOf("Lively", "Loyal", "Courageous")
            ),
            Pet(
                id = "89aosdijas4",
                breed = "Shiba Inu",
                description = "An ancient Japanese breed that has been around since at least 300 B.C., the Shiba Inu was originally developed for hunting by sight and scent in the dense undergrowth of Japan’s rugged mountains. ‘Shiba’ means ‘brushwood’ in Japanese, referring either to the brush in the mountains or to the dog’s reddish colour, while ‘Inu’ means ‘dog’.",
                image = "",
                price = 48000.00,
                age = 2,
                weight = 12.1,
                color = "Brown",
                healthRisk = "This breed has an around average probability of having health issues in its lifetime, hence it is one of the more affordable breeds to insure.",
                temperament = listOf("Affectionate", "Spirited")
            ),

            Pet(
                id = "67ekandka23",
                breed = "Newfoundland",
                description = "The Newfoundland is a giant, very muscular, strong dog that is equipped with a heavy double coat of fur. Originally developed in Canada as a working dog and companion to fisherman, the Newfoundland is a stoic and even-tempered breed, known for its excellent swimming capabilities and brave, loyal nature.",
                image = "",
                price = 60000.00,
                age = 4,
                weight = 18.8,
                color = "Black",
                healthRisk = "High probability of health issues during its lifetime, hence it is one of the more expensive breeds to insure.",
                temperament = listOf("Loyal", "Gentle", "Friendly")
            ),
            Pet(
                id = "en33ao67sdijas4",
                breed = "British Bulldog",
                description = "A direct decedent of the ancient Mastiff breeds and thought to have been mixed with Old English Terrier types, the Bulldog was developed entirely in England. The breed was first noted in the 1500s in the description of a man who had ‘two Bolddogges by his side’.\n" +
                        "\n" +
                        "The name ‘Bulldog’ comes from the practice of bull baiting, the task for which the breed was developed. The English believed that if a bull could be tied down and provoked into a rage by a dog, its meat would end up being much more tender and delicious",
                image = "",
                price = 37000.00,
                age = 1,
                weight = 13.6,
                color = "White-Brown",
                healthRisk = "High probability of health issues during its lifetime, hence it is one of the more expensive breeds to insure.",
                temperament = listOf("Gentle", "Stubborn", "Affectionate")
            ),

            Pet(
                id = "99asdnad22",
                breed = "Shiba Inu",
                description = "The German Shepherd Dog is a relatively new breed that was developed in the 1890’s by a German cavalry officer named Max von Stephanitz, who made it his goal to develop the ideal herding dog. He admired the intelligence, strength and ability of the sheepdogs native to Germany, but believed that none was the perfect working dog.",
                image = "",
                price = 45000.00,
                age = 1,
                weight = 13.5,
                color = "Brown",
                healthRisk = "This breed has an around average probability of having health issues in its lifetime, hence it is one of the more affordable breeds to insure.",
                temperament = listOf("Alert", "Fearless", "Faithful")
            )
        )
    }

    private val colors by lazy {
        listOf("Brown", "White", "Black", "Dimension", "White-Black", "White-Brown")
    }

    private val favouritePets = MutableStateFlow(setOf<String>())
    override fun getAllPets(filter: PetsFilter?): Flow<List<Pet>> = flow {
        // Apply filter here this could be database filter
        filter?.let { filter ->
            val filteredPets = pets.filter { pet ->
                (filter.color == null || pet.color == filter.color) &&
                        (filter.priceRange == null || (pet.price >= filter.priceRange.start && pet.price <= filter.priceRange.end)) &&
                        (filter.age == null || (pet.age >= filter.age.start && pet.age <= filter.age.end)) &&
                        (filter.weightRange == null || (pet.weight >= filter.weightRange.start && pet.weight <= filter.weightRange.end))
            }
            emit(filteredPets)
        } ?: emit(pets)
    }

    override suspend fun toggleFavouritePet(pet: Pet) {
        favouritePets.update {
            it.addOrRemove(pet.id)
        }
    }

    override fun getAllFavouritePets(): Flow<Set<String>> = favouritePets
    override fun getAllColors(): Result<List<String>> {
        return Result.success(colors)
    }
}