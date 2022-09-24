package com.sriyank.recyclerviewkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myArray: ArrayList<ItemData>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var body: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.ceres,
            R.drawable.darkspot,
            R.drawable.dysnomia,
            R.drawable.gas,
            R.drawable.gaspra,
            R.drawable.heliospheric,
            R.drawable.jupiter,
            R.drawable.kuiper,
            R.drawable.sun,
            R.drawable.venuspioneeruv
        )

        heading = arrayOf(
            "The asteroid belt is the region of the solar system that lies between the planets Mars and Jupiter.",
            "Neptune is a gas giant and the most distant planet from the sun at all.",
            "A dwarf planet is an object of planetary mass, which does not dominate its space surroundings.",
            "The outer solar system is the part that lies outside the asteroid belt of the solar system.",
            "the International Astronomical Union defined a small solar system body as any body revolving around the sun.",
            "The sun radiates along the light charged particles known as the solar wind.",
            "Mercury Venus Earth Mars Jupiter Saturn Uranus Neptune The eight known planets of the solar system.",
            "The inner planets are all rocky (that is, they are composed mainly of silicates and minerals ).",
            "The sun is the star of the solar system, the main element and the largest mass in the group.",
            "Venus is the second closest planet to the sun after Mercury. It is often called the Earth's twin."
            )

        body = arrayOf(
             "The asteroid belt is the region of the solar system that lies between the planets Mars and Jupiter, and it consists of thousands of asteroids of various sizes, ranging in diameter from approximately one thousand kilometers to the size of dust particles. Almost half of the mass of the belt consists of Ceres , Vesta and Palas alone, " +
                     "and the first of them is the largest asteroid and the only dwarf planet in the belt, with a mass of a quarter of the total mass of the region.  The total number of asteroids in the belt that has a diameter greater than one kilometer is estimated at seven hundred and fifty thousand, and there are millions of smaller bodies than that. " +
                     "It is not yet established how the asteroid belt formed, but it is believed to be a remnant of a proto-planetary disk of a planet that did not form (possibly due to Jupiter's gravity ). " +
                     "It has sent a few vehicles to explore this area, and the information about it is not much yet, but most of the information about it comes from the meteorites that fell to the surface of the Earth and that may have formed within the belt.  This belt is considered to be the separator between the inner and outer parts of the solar system.",

        "Neptune is a gas giant and the most distant planet from the sun at all, its distance from it is 30 times the distance of the earth, and it is also the only planet that can not be seen at any time without a telescope. The diameter of Neptune is 4 times the diameter of the Earth, and it has 15 moons (the largest is Triton )  and many thin rings around it. " +
                "The story of the discovery of this planet is long and complex, and astronomers differ about who deserves the true honor of discovering it, as it was done through a long series of calculations and observations made by different people over many years. " +
                "Neptune\'s magnetic field is not strong, its strength is approximately equal to the strength of Earth's field. Neptune does not have a solid surface, but instead its surface consists of a layer of thick blue clouds, under which there is a layer of liquid and then a rocky core. " +
                "The winds on Neptune are very fast (1,100 km per hour), and some storms have been previously observed on it, the most famous of which is the Great Dark Spot, which is similar to Jupiter's spot.",

        "Within the 2006 definition of solar system bodies, a new class of bodies was created, \" dwarf planets \", which are, by definition, celestial bodies: 1. It has orbits around the sun ." +
                "2. It has enough mass - or rather gravity - to create a hydrostatic equilibrium capable of making it spherical or spherical in shape. " +
                "But the last point that separates them from the planets is that they \"do not have enough gravitational pull to clean their orbits of neighboring bodies.\" As mentioned earlier, this definition does not apply to subordinates .  This decision came as a solution to the long-running controversy over the classification of the planet Pluto , " +
                "which began mainly after the determination of Pluto\'s position in the Kipper belt and the knowledge of the existence of bodies similar in size to it. At that time, the situation began to deteriorate and the controversy increased over his classification and the neighboring bodies together as planets or together as another class of bodies.  In 2004 , " +
                "Sedna was discovered, which became the closest object to Pluto in size (at that time the diameter of Sedna was set at 1,800 km and Pluto at 2,320 km), which made the controversy increase. The controversy reached its climax with the discovery of an object even larger than Pluto, which is Eris . This new definition has finally resolved that long debate. " +
                "Despite this, not everyone was satisfied with the reclassification of Pluto, and many people, even astronomers, are still calling for Pluto to be reclassified as planets.  Currently, there are five bodies agreed to be classified as dwarf planets (although there are other candidates who could be classified as such if more information is available about them): Ceres (in the asteroid belt )  Pluto  and Haukea  Mimic  (in the Kuiper belt )  and Eris (in the-scattered disk ).",

        "The outer solar system is the part that lies outside the asteroid belt of the solar system, although some astronomers consider it to be the trans-Neptunian region while the giant planets are the middle solar system.  All the planets of this region of the solar system are gas giants (Jupiter - Saturn - Uranus - Neptune), and they are much larger than the inner planets, as they make up 99% of the bodies that revolve around the sun. " +
                "Although these planets consist primarily of gas, they have rocky cores made up of liquid heavy metals. The outer planets are also characterized by a large number of moons, Jupiter alone has more than 60 moons. In addition, all of these giants have ring systems, although it is very thin and invisible from Earth to all of them except Saturn (in contrast to the inner planets, which do not have any of them rings and the sum of their moons is only 3).",

        "In 2006 , the International Astronomical Union defined a small solar system body as any body revolving around the sun , as the following was said at the general meeting of the International Astronomical Union in 2006 after defining each of the planets and dwarf planets :\" All other bodies revolving around the Sun will be collectively called \'small bodies of the solar system\' . These will include most asteroids in the solar system, most trans-Neptune bodies, and all comets and other small objects.\" Hence, with the exception of the planets and dwarf planets, the name of all other bodies in the solar system has become “small solar system bodies”, which are defined only as “objects revolving around the sun” (which includes all comets , meteorites , most asteroids , " +
                "near-Earth bodies and other objects ). beyond Neptune ). Dependencies are excluded from this definition like the rest of the definitions mentioned earlier. " +
                "Here are some types of small solar system bodies and their definitions: +" +
                "Asteroids : They are small solar system bodies smaller than planets and larger than meteorites , and the difference between them and comets is that those show tails behind them when they approach the sun , while asteroids do not. " +
                "Comets : They are small solar system bodies that show tails as they approach the sun. " +
                "Meteorites : They are small solar system bodies, solid bodies that move in the interplanetary medium, their sizes are larger than atoms and smaller than asteroids.",

        "The sun radiates along the light charged particles known as the solar wind . The stream of particles spreads outward at about 1.5 million kilometers per hour,  forming a thin envelope that penetrates beyond the Sun\'s system for at least 100 AU .  This is known as the mean between the planets. " +
                "Geomagnetic storms such as solar eruptions and coronal mass ejections disturb the heliosphere and give rise to what is known as space weathering . " +
                "The larger structure of the heliosphere is the periodic heliosphere stream, which is a spiral shape that arises as a result of the interaction between the rotation of the solar magnetic field in the interplanetary medium. " +
                "The Earth\'s magnetic field keeps the atmosphere from escaping from Earth\'s circumference with the solar wind. Due to the absence of a magnetic field for Mars and Venus, their atmospheres will gradually escape with the solar wind. " +
                "Coronal mass ejections and similar events, blowing with the magnetic field laden with massive amounts of particles from the surface of the Sun. This magnetic field and particles interact with the Earth\'s magnetic field in the upper layers of the atmosphere , " +
                "and this results in the phenomenon of auroras that appear near the magnetic poles. Cosmic rays originate outside the solar system, the heliosphere forms a protective shield against these rays, and the magnetic fields of planets (which have a magnetic field) provide partial protection. The intensity of cosmic rays in the interstellar medium and the intensity of the solar magnetic field changes over a very long time, so the amount of cosmic rays in the solar system varies over time, but the quality and quantity is unknown. " +
                "The interplanetary medium is home to at least two regions resembling the cosmic dust disk . The first is the zodiac dust cloud located in the inner solar system and causes zodiacal light . It likely originated from a collision within the asteroid belt. The second is 10 to 40 astronomical units in length, and most likely arose as a result of a collision within the Kuiper belt.",

        "The International Astronomical Union defines a planet in the solar system as a celestial body:" +
                "1. It has an orbit around the sun . 2. It has sufficient mass - or rather gravity - to create a hydrostatic equilibrium capable of making its shape spherical or spherical. 3. It has enough gravity to clean its orbit of neighboring bodies." +
                "Dependencies are excluded from this definition, as mentioned previously.  The bodies that fulfill these conditions in the solar system are: Mercury - Venus - Earth - Mars ( rocky planets ), Jupiter - Saturn - Uranus - Neptune ( the gas giants )." +
                "While Pluto and a few other objects fail to meet the latter condition, Pluto's mass is only 0.07 that of the other objects in its orbit . For comparison, Earth's mass is 1.7 million times the mass remaining in its orbit.",

        "The Kuiper Belt is from a region of the Solar System located directly behind the planet Neptune, so that the orbits of some belt objects intersect with the orbit of Neptune.  This belt is very similar to the asteroid belt, except that it consists mainly of rocky and mineral materials, while most of the Kuiper belt bodies are entirely composed of a mixture of ice of both water and ammonia , in addition to various hydrocarbons such as methane (which are similar to comets in their composition). . Scientists believe there are more than 70,000 objects in the Kuiper Belt, although very few have been found so far." +
                "Some belt objects are quite massive, and in fact the dwarf planet Pluto is thought to be one of the largest. Also, Pluto is the largest belt body known so far, although there are other bodies of similar size, such as Haumea and Makemaki . A number of these bodies have moons around them, including Pluto, Haumea, and others.  It is believed that the Kuiper Belt is the source of some comets (particularly since their bodies are similar in composition), especially periodic comets , although most of them come from the distant Oort Cloud ." +
                "  No spacecraft has reached the belt yet, although a spacecraft called “New Horizons” is currently on its way to it, and it is expected to reach Pluto by 2015.",

        "The sun is the star of the solar system, the main element and the largest mass in the group (its mass is about 332,900 times the mass of the Earth).  The density and heat produced in the core of the sun\'s core are sufficient to sustain nuclear reactions, which release large amounts of energy, the greatest of which is in the form of radiant energy to outer space such as electromagnetic radiation . Its peak is between four hundred and seven hundred nanometers." +
                "This beam is called visible light .The sun is classified as a yellow dwarf of type G2. But this name is misleading compared to the rest of the stars in our galaxy , as the Sun is larger and brighter.  Stars are classified according to the Hertzsprung-Russell classification , based on the representation of stars on a chart according to their luminosity due to their surface temperature. In general, stars with a higher temperature are brighter." +
                "Stars that follow this classification are called a main sequence star . The sun is to the right of the center of this chart. However, stars that are hotter and brighter than the Sun are rare. While the fainter and cooler stars are called red dwarfs , they are the most common in the galaxy and make up about 85% of the stars in our galaxy.",

        "Venus is the second closest planet to the sun after Mercury. It is often called the Earth\'s twin because the two planets are very similar in size and mass. It is also the closest planet to it. Venus - as seen from Earth - is the brightest object in the sky after the sun and the moon," +
                "meaning that it is brighter than all the other stars and planets. Venus, as it appears to the observer from Earth, shows phases like the moon as it revolves around the sun. It appears so because its orbit lies within the Earth\'s orbit. Venus - unlike all the other planets - revolves around itself from east to west, meaning that the sun rises on it from the west." +
                "Like Mercury, Venus has no moons. There is a thick layer of clouds in its atmosphere, which causes the phenomenon of a strong greenhouse , which makes it very hot, Its surface temperature exceeds 400 degrees Celsius, and thus it becomes the hottest planet in the entire solar system, and it is even hotter than Mercury, which lies closer to the sun."

        )

        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.setHasFixedSize(true)

        getData()

    }

    private fun getData() {

        myArray = arrayListOf<ItemData>()

        var newArray = arrayListOf<ItemData>()

        for(i in imageId.indices){
            myArray.add(ItemData( i + 1,imageId[i],heading[i]))
        }
        val adapter = MyAdapter(myArray)
        recycleView.adapter = adapter

        update.setOnClickListener {
            for (i in 0..4) {
                newArray.add(ItemData(i + 1, imageId[i], heading[i]))
            }
            adapter.setData(newArray)
        }

        adapter.setOnClickListener(object : MyAdapter.onItemClickListener{

            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity,NewActivity::class.java)

                intent.putExtra("image",imageId[position])
                intent.putExtra("head",heading[position])
                intent.putExtra("body",body[position])

                startActivity(intent)
            }

        })
    }
}