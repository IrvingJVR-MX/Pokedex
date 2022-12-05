package com.example.pokedex.utils

class PokemonHelper {
    object Constants {
        const val pokemonListLimit = 25
        val pokemonMapColor = mutableMapOf(
            "1" to "#8abe8a",
            "2" to "#8abe8a",
            "3" to "#8abe8a",
            "4" to "#ffa756",
            "5" to "#ffa756",
            "6" to "#ffa756",
            "7" to "#58abf6",
            "8" to "#58abf6",
            "9" to "#58abf6",
            "10" to "#8abe8a",
            "11" to "#8abe8a",
            "12" to "#8cb230",
            "13" to "#7c5151",
            "14" to "#f0f060e6",
            "15" to "#f0f060e6",
            "16" to "#7c5151",
            "17" to "#7c5151",
            "18" to "#7c5151",
            "19" to "#523352",
            "20" to "#7c5151",
            "21" to "#7c5151",
            "22" to "#7c5151",
            "23" to "#523352",
            "24" to "#523352",
            "25" to "#f2cb55",
            "26" to "#f2cb55",
            "27" to "#f0f060e6",
            "28" to "#f0f060e6",
            "29" to "#58abf6",
            "30" to "#58abf6",
            "31" to "#58abf6",
            "32" to "#523352",
            "33" to "#523352",
            "34" to "#523352",
            "35" to "#ffb6c3",
            "36" to "#ffb6c3",
            "37" to "#7c5151",
            "38" to "#f0f060e6",
            "39" to "#ffb6c3",
            "40" to "#ffb6c3",
            "41" to "#523352",
            "42" to "#523352",
            "43" to "#58abf6",
            "44" to "#58abf6",
            "45" to "#ffa756",
            "46" to "#ffa756",
            "47" to "#ffa756",
            "48" to "#523352",
            "49" to "#523352",
            "50" to "#7c5151",
            "51" to "#7c5151",
            "52" to "#f0f060e6",
            "53" to "#f0f060e6",
            "54" to "#58abf6",
            "55" to "#58abf6",
            "56" to "#7c5151",
            "57" to "#7c5151",
            "58" to "#7c5151",
            "59" to "#7c5151",
            "60" to "#58abf6",
            "61" to "#58abf6",
            "62" to "#58abf6",
            "63" to "#7c5151",
            "64" to "#7c5151",
            "65" to "#7c5151",
            "66" to "#808080",
            "67" to "#808080",
            "68" to "#808080",
            "69" to "#8abe8a",
            "70" to "#8abe8a",
            "71" to "#8abe8a",
            "72" to "#58abf6",
            "73" to "#58abf6",
            "74" to "#7c5151",
            "75" to "#7c5151",
            "76" to "#7c5151",
            "77" to "#f0f060e6",
            "78" to "#f0f060e6",
            "79" to "#ffb6c3",
            "80" to "#ffb6c3",
            "81" to "#808080",
            "82" to "#808080",
            "83" to "#7c5151",
            "84" to "#7c5151",
            "85" to "#7c5151",
            "86" to "#58abf6",
            "87" to "#58abf6",
            "88" to "#523352",
            "89" to "#523352",
            "90" to "#523352",
            "91" to "#523352",
            "92" to "#523352",
            "93" to "#523352",
            "94" to "#523352",
            "95" to "#808080",
            "96" to "#f0f060e6",
            "97" to "#f0f060e6",
            "98" to "#ffa756",
            "99" to "#ffa756",
            "100" to "#ffa756",
            "101" to "#ffa756",
            "102" to "#ffb6c3",
            "103" to "#f0f060e6",
            "104" to "#7c5151",
            "105" to "#7c5151",
            "106" to "#7c5151",
            "107" to "#7c5151",
            "108" to "#ffb6c3",
            "109" to "#523352",
            "110" to "#523352",
            "111" to "#808080",
            "112" to "#808080",
            "113" to "#ffb6c3",
            "114" to "#58abf6",
            "115" to "#7c5151",
            "116" to "#58abf6",
            "117" to "#58abf6",
            "118" to "#ffa756",
            "119" to "#ffa756",
            "120" to "#7c5151",
            "121" to "#523352",
            "122" to "#ffb6c3",
            "123" to "#8abe8a",
            "124" to "#ffa756",
            "125" to "#f0f060e6",
            "126" to "#ffa756",
            "127" to "#7c5151",
            "128" to "#7c5151",
            "129" to "#ffa756",
            "130" to "#58abf6",
            "131" to "#58abf6",
            "132" to "#523352",
            "133" to "#7c5151",
            "134" to "#58abf6",
            "135" to "#f0f060e6",
            "136" to "#ffa756",
            "137" to "#ffb6c3",
            "138" to "#58abf6",
            "139" to "#58abf6",
            "140" to "#7c5151",
            "141" to "#7c5151",
            "142" to "#523352",
            "143" to "#000000",
            "144" to "#58abf6",
            "145" to "#f0f060e6",
            "146" to "#f0f060e6",
            "147" to "#58abf6",
            "148" to "#58abf6",
            "149" to "#7c5151",
            "150" to "#523352",
            "151" to "#ffb6c3",
            "152" to "#8abe8a",
            "153" to "#8abe8a",
            "154" to "#8abe8a",
            "155" to "#ffa756",
            "156" to "#ffa756",
            "157" to "#ffa756",
            "158" to "#58abf6",
            "159" to "#58abf6",
            "160" to "#58abf6",
            "161" to "#7c5151",
            "162" to "#7c5151",
            "163" to "#7c5151",
            "164" to "#7c5151",
            "165" to "#ffa756",
            "166" to "#ffa756",
            "167" to "#8abe8a",
            "168" to "#ffa756",
            "169" to "#523352",
            "170" to "#58abf6",
            "171" to "#58abf6",
            "172" to "#f2cb55",
            "173" to "#ffb6c3",
            "174" to "#ffb6c3",
            "175" to "#ed6ec7",
            "176" to "#ed6ec7",
            "177" to "#8abe8a",
            "178" to "#8abe8a",
            "179" to "#f2cb55",
            "180" to "#ffb6c3",
            "181" to "#f0f060e6",
            "182" to "#8abe8a",
            "183" to "#58abf6",
            "184" to "#58abf6",
            "185" to "#7c5151",
            "186" to "#8abe8a",
            "187" to "#ffb6c3",
            "188" to "#8abe8a",
            "189" to "#58abf6",
            "190" to "#523352",
            "191" to "#f0f060e6",
            "192" to "#f0f060e6",
            "193" to "#ffa756",
            "194" to "#58abf6",
            "195" to "#58abf6",
            "196" to "#523352",
            "197" to "#000000",
            "198" to "#000000",
            "199" to "#ffb6c3",
            "200" to "#808080",
            "201" to "#000000",
            "202" to "#58abf6",
            "203" to "#f0f060e6",
            "204" to "#808080",
            "205" to "#523352",
            "206" to "#f0f060e6",
            "207" to "#523352",
            "208" to "#808080",
            "209" to "#ffb6c3",
            "210" to "#523352",
            "211" to "#808080",
            "212" to "#ffa756",
            "213" to "#f0f060e6",
            "214" to "#58abf6",
            "215" to "#000000",
            "216" to "#7c5151",
            "217" to "#7c5151",
            "218" to "#ffa756",
            "219" to "#ffa756",
            "220" to "#7c5151",
            "221" to "#7c5151",
            "222" to "#ffb6c3",
            "223" to "#808080",
            "224" to "#ffa756",
            "225" to "#ffa756",
            "226" to "#523352",
            "227" to "#808080",
            "228" to "#000000",
            "229" to "#000000",
            "230" to "#58abf6",
            "231" to "#58abf6",
            "232" to "#808080",
            "233" to "#ffa756",
            "234" to "#7c5151",
            "235" to "#b5b9c4",
            "236" to "#523352",
            "237" to "#7c5151",
            "238" to "#ffb6c3",
            "239" to "#f0f060e6",
            "240" to "#ffa756",
            "241" to "#ffb6c3",
            "242" to "#ffb6c3",
            "243" to "#f0f060e6",
            "244" to "#7c5151",
            "245" to "#58abf6",
            "246" to "#8abe8a",
            "247" to "#808080",
            "248" to "#8abe8a",
            "249" to "#ea5d60",
            "250" to "#ffa756",
            "251" to "#8abe8a",
            "252" to "#8abe8a",
            "253" to "#8abe8a",
            "254" to "#8abe8a",
            "255" to "#ffa756",
            "256" to "#ffa756",
            "257" to "#ffa756",
            "258" to "#58abf6",
            "259" to "#58abf6",
            "260" to "#58abf6",
            "261" to "#808080",
            "262" to "#808080",
            "263" to "#7c5151",
            "264" to "#fbf6f6",
            "265" to "#ffa756",
            "266" to "#fbf6f6",
            "267" to "#f0f060e6",
            "268" to "#523352",
            "269" to "#8abe8a",
            "270" to "#8abe8a",
            "271" to "#8abe8a",
            "272" to "#8abe8a",
            "273" to "#7c5151",
            "274" to "#7c5151",
            "275" to "#7c5151",
            "276" to "#58abf6",
            "277" to "#58abf6",
            "278" to "#fbf6f6",
            "279" to "#f0f060e6",
            "280" to "#fbf6f6",
            "281" to "#fbf6f6",
            "282" to "#fbf6f6",
            "283" to "#58abf6",
            "284" to "#58abf6",
            "285" to "#7c5151",
            "286" to "#8abe8a",
            "287" to "#7c5151",
            "288" to "#fbf6f6",
            "289" to "#7c5151",
            "290" to "#808080",
            "291" to "#f0f060e6",
            "292" to "#7c5151",
            "293" to "#ffb6c3",
            "294" to "#58abf6",
            "295" to "#58abf6",
            "296" to "#f0f060e6",
            "297" to "#7c5151",
            "298" to "#58abf6",
            "299" to "#808080",
            "300" to "#ffb6c3",
            "301" to "#523352",
            "302" to "#523352",
            "303" to "#000000",
            "304" to "#808080",
            "305" to "#808080",
            "306" to "#808080",
            "307" to "#58abf6",
            "308" to "#ffa756",
            "309" to "#8abe8a",
            "310" to "#f0f060e6",
            "311" to "#f0f060e6",
            "312" to "#f0f060e6",
            "313" to "#808080",
            "314" to "#523352",
            "315" to "#8abe8a",
            "316" to "#8abe8a",
            "317" to "#523352",
            "318" to "#ffa756",
            "319" to "#58abf6",
            "320" to "#58abf6",
            "321" to "#58abf6",
            "322" to "#f0f060e6",
            "323" to "#ffa756",
            "324" to "#7c5151",
            "325" to "#000000",
            "326" to "#523352",
            "327" to "#7c5151",
            "328" to "#7c5151",
            "329" to "#8abe8a",
            "330" to "#8abe8a",
            "331" to "#8abe8a",
            "332" to "#8abe8a",
            "333" to "#58abf6",
            "334" to "#58abf6",
            "335" to "#fbf6f6",
            "336" to "#000000",
            "337" to "#f0f060e6",
            "338" to "#ffa756",
            "339" to "#808080",
            "340" to "#58abf6",
            "341" to "#ffa756",
            "342" to "#ffa756",
            "343" to "#7c5151",
            "344" to "#000000",
            "345" to "#523352",
            "346" to "#8abe8a",
            "347" to "#808080",
            "348" to "#808080",
            "349" to "#7c5151",
            "350" to "#ffb6c3",
            "351" to "#808080",
            "352" to "#8abe8a",
            "353" to "#000000",
            "354" to "#000000",
            "355" to "#000000",
            "356" to "#000000",
            "357" to "#8abe8a",
            "358" to "#58abf6",
            "359" to "#fbf6f6",
            "360" to "#58abf6",
            "361" to "#808080",
            "362" to "#808080",
            "363" to "#58abf6",
            "364" to "#58abf6",
            "365" to "#58abf6",
            "366" to "#58abf6",
            "367" to "#58abf6",
            "368" to "#ffb6c3",
            "369" to "#808080",
            "370" to "#ffb6c3",
            "371" to "#58abf6",
            "372" to "#fbf6f6",
            "373" to "#58abf6",
            "374" to "#58abf6",
            "375" to "#58abf6",
            "376" to "#58abf6",
            "377" to "#7c5151",
            "378" to "#58abf6",
            "379" to "#808080",
            "380" to "#ffa756",
            "381" to "#58abf6",
            "382" to "#58abf6",
            "383" to "#ffa756",
            "384" to "#8abe8a",
            "385" to "#f0f060e6",
            "386" to "#ffa756",
            "387" to "#8abe8a",
            "388" to "#8abe8a",
            "389" to "#8abe8a",
            "390" to "#7c5151",
            "391" to "#7c5151",
            "392" to "#7c5151",
            "393" to "#58abf6",
            "394" to "#58abf6",
            "395" to "#58abf6",
            "396" to "#7c5151",
            "397" to "#7c5151",
            "398" to "#7c5151",
            "399" to "#7c5151",
            "400" to "#7c5151",
            "401" to "#ffa756",
            "402" to "#ffa756",
            "403" to "#58abf6",
            "404" to "#58abf6",
            "405" to "#58abf6",
            "406" to "#8abe8a",
            "407" to "#8abe8a",
            "408" to "#58abf6",
            "409" to "#58abf6",
            "410" to "#808080",
            "411" to "#808080",
            "412" to "#8abe8a",
            "413" to "#8abe8a",
            "414" to "#f0f060e6",
            "415" to "#f0f060e6",
            "416" to "#f0f060e6",
            "417" to "#fbf6f6",
            "418" to "#7c5151",
            "419" to "#7c5151",
            "420" to "#ffb6c3",
            "421" to "#523352",
            "422" to "#523352",
            "423" to "#523352",
            "424" to "#523352",
            "425" to "#523352",
            "426" to "#523352",
            "427" to "#7c5151",
            "428" to "#7c5151",
            "429" to "#523352",
            "430" to "#000000",
            "431" to "#808080",
            "432" to "#808080",
            "433" to "#f0f060e6",
            "434" to "#523352",
            "435" to "#523352",
            "436" to "#8abe8a",
            "437" to "#8abe8a",
            "438" to "#7c5151",
            "439" to "#ffb6c3",
            "440" to "#ffb6c3",
            "441" to "#000000",
            "442" to "#523352",
            "443" to "#58abf6",
            "444" to "#58abf6",
            "445" to "#58abf6",
            "446" to "#000000",
            "447" to "#58abf6",
            "448" to "#58abf6",
            "449" to "#7c5151",
            "450" to "#7c5151",
            "451" to "#523352",
            "452" to "#523352",
            "453" to "#58abf6",
            "454" to "#58abf6",
            "455" to "#8abe8a",
            "456" to "#58abf6",
            "457" to "#58abf6",
            "458" to "#58abf6",
            "459" to "#fbf6f6",
            "460" to "#fbf6f6",
            "461" to "#000000",
            "462" to "#808080",
            "463" to "#ffb6c3",
            "464" to "#808080",
            "465" to "#58abf6",
            "466" to "#f0f060e6",
            "467" to "#ffa756",
            "468" to "#fbf6f6",
            "469" to "#8abe8a",
            "470" to "#8abe8a",
            "471" to "#58abf6",
            "472" to "#523352",
            "473" to "#7c5151",
            "474" to "#ffa756",
            "475" to "#fbf6f6",
            "476" to "#808080",
            "477" to "#000000",
            "478" to "#fbf6f6",
            "479" to "#ffa756",
            "480" to "#f0f060e6",
            "481" to "#ffb6c3",
            "482" to "#58abf6",
            "483" to "#fbf6f6",
            "484" to "#523352",
            "485" to "#7c5151",
            "486" to "#fbf6f6",
            "487" to "#000000",
            "488" to "#f0f060e6",
            "489" to "#58abf6",
            "490" to "#58abf6",
            "491" to "#000000",
            "492" to "#8abe8a",
            "493" to "#fbf6f6",
            "494" to "#f0f060e6",
            "495" to "#8abe8a",
            "496" to "#8abe8a",
            "497" to "#8abe8a",
            "498" to "#ffa756",
            "499" to "#ffa756",
            "500" to "#ffa756",
            "501" to "#58abf6",
            "502" to "#58abf6",
            "503" to "#58abf6",
            "504" to "#7c5151",
            "505" to "#7c5151",
            "506" to "#7c5151",
            "507" to "#808080",
            "508" to "#808080",
            "509" to "#523352",
            "510" to "#523352",
            "511" to "#8abe8a",
            "512" to "#8abe8a",
            "513" to "#ffa756",
            "514" to "#ffa756",
            "515" to "#58abf6",
            "516" to "#58abf6",
            "517" to "#ffb6c3",
            "518" to "#ffb6c3",
            "519" to "#808080",
            "520" to "#808080",
            "521" to "#808080",
            "522" to "#000000",
            "523" to "#000000",
            "524" to "#58abf6",
            "525" to "#58abf6",
            "526" to "#58abf6",
            "527" to "#58abf6",
            "528" to "#58abf6",
            "529" to "#808080",
            "530" to "#808080",
            "531" to "#ffb6c3",
            "532" to "#808080",
            "533" to "#808080",
            "534" to "#7c5151",
            "535" to "#58abf6",
            "536" to "#58abf6",
            "537" to "#58abf6",
            "538" to "#ffa756",
            "539" to "#58abf6",
            "540" to "#f0f060e6",
            "541" to "#8abe8a",
            "542" to "#f0f060e6",
            "543" to "#ffa756",
            "544" to "#808080",
            "545" to "#ffa756",
            "546" to "#8abe8a",
            "547" to "#8abe8a",
            "548" to "#8abe8a",
            "549" to "#8abe8a",
            "550" to "#8abe8a",
            "551" to "#7c5151",
            "552" to "#7c5151",
            "553" to "#ffa756",
            "554" to "#ffa756",
            "555" to "#ffa756",
            "556" to "#8abe8a",
            "557" to "#ffa756",
            "558" to "#ffa756",
            "559" to "#f0f060e6",
            "560" to "#ffa756",
            "561" to "#000000",
            "562" to "#000000",
            "563" to "#f0f060e6",
            "564" to "#58abf6",
            "565" to "#58abf6",
            "566" to "#f0f060e6",
            "567" to "#f0f060e6",
            "568" to "#8abe8a",
            "569" to "#8abe8a",
            "570" to "#808080",
            "571" to "#808080",
            "572" to "#808080",
            "573" to "#808080",
            "574" to "#523352",
            "575" to "#523352",
            "576" to "#523352",
            "577" to "#8abe8a",
            "578" to "#8abe8a",
            "579" to "#8abe8a",
            "580" to "#58abf6",
            "581" to "#fbf6f6",
            "582" to "#fbf6f6",
            "583" to "#fbf6f6",
            "584" to "#fbf6f6",
            "585" to "#ffb6c3",
            "586" to "#7c5151",
            "587" to "#fbf6f6",
            "588" to "#58abf6",
            "589" to "#808080",
            "590" to "#fbf6f6",
            "591" to "#fbf6f6",
            "592" to "#fbf6f6",
            "593" to "#fbf6f6",
            "594" to "#ffb6c3",
            "595" to "#f0f060e6",
            "596" to "#f0f060e6",
            "597" to "#808080",
            "598" to "#808080",
            "599" to "#808080",
            "600" to "#808080",
            "601" to "#808080",
            "602" to "#fbf6f6",
            "603" to "#58abf6",
            "604" to "#58abf6",
            "605" to "#58abf6",
            "606" to "#7c5151",
            "607" to "#fbf6f6",
            "608" to "#000000",
            "609" to "#000000",
            "610" to "#8abe8a",
            "611" to "#8abe8a",
            "612" to "#f0f060e6",
            "613" to "#fbf6f6",
            "614" to "#fbf6f6",
            "615" to "#58abf6",
            "616" to "#ffa756",
            "617" to "#ffa756",
            "618" to "#7c5151",
            "619" to "#f0f060e6",
            "620" to "#523352",
            "621" to "#ffa756",
            "622" to "#8abe8a",
            "623" to "#8abe8a",
            "624" to "#ffa756",
            "625" to "#ffa756",
            "626" to "#7c5151",
            "627" to "#fbf6f6",
            "628" to "#ffa756",
            "629" to "#7c5151",
            "630" to "#7c5151",
            "631" to "#ffa756",
            "632" to "#808080",
            "633" to "#58abf6",
            "634" to "#58abf6",
            "635" to "#58abf6",
            "636" to "#fbf6f6",
            "637" to "#fbf6f6",
            "638" to "#58abf6",
            "639" to "#808080",
            "640" to "#8abe8a",
            "641" to "#8abe8a",
            "642" to "#58abf6",
            "643" to "#fbf6f6",
            "644" to "#000000",
            "645" to "#7c5151",
            "646" to "#808080",
            "647" to "#f0f060e6",
            "648" to "#fbf6f6",
            "649" to "#523352",
            "650" to "#8abe8a",
            "651" to "#8abe8a",
            "652" to "#8abe8a",
            "653" to "#ffa756",
            "654" to "#ffa756",
            "655" to "#ffa756",
            "656" to "#58abf6",
            "657" to "#58abf6",
            "658" to "#58abf6",
            "659" to "#7c5151",
            "660" to "#7c5151",
            "661" to "#ffa756",
            "662" to "#ffa756",
            "663" to "#ffa756",
            "664" to "#000000",
            "665" to "#000000",
            "666" to "#fbf6f6",
            "667" to "#7c5151",
            "668" to "#7c5151",
            "669" to "#fbf6f6",
            "670" to "#fbf6f6",
            "671" to "#fbf6f6",
            "672" to "#7c5151",
            "673" to "#7c5151",
            "674" to "#fbf6f6",
            "675" to "#fbf6f6",
            "676" to "#fbf6f6",
            "677" to "#808080",
            "678" to "#58abf6",
            "679" to "#7c5151",
            "680" to "#7c5151",
            "681" to "#7c5151",
            "682" to "#ffb6c3",
            "683" to "#ffb6c3",
            "684" to "#fbf6f6",
            "685" to "#fbf6f6",
            "686" to "#58abf6",
            "687" to "#58abf6",
            "688" to "#7c5151",
            "689" to "#7c5151",
            "690" to "#7c5151",
            "691" to "#7c5151",
            "692" to "#58abf6",
            "693" to "#58abf6",
            "694" to "#f0f060e6",
            "695" to "#f0f060e6",
            "696" to "#7c5151",
            "697" to "#ffa756",
            "698" to "#58abf6",
            "699" to "#58abf6",
            "700" to "#ffb6c3",
            "701" to "#8abe8a",
            "702" to "#f0f060e6",
            "703" to "#808080",
            "704" to "#523352",
            "705" to "#523352",
            "706" to "#523352",
            "707" to "#808080",
            "708" to "#7c5151",
            "709" to "#7c5151",
            "710" to "#7c5151",
            "711" to "#7c5151",
            "712" to "#58abf6",
            "713" to "#58abf6",
            "714" to "#523352",
            "715" to "#523352",
            "716" to "#58abf6",
            "717" to "#ffa756",
            "718" to "#8abe8a",
            "719" to "#ffb6c3",
            "720" to "#523352",
            "721" to "#7c5151",
            "722" to "#7c5151",
            "723" to "#7c5151",
            "724" to "#7c5151",
            "725" to "#ffa756",
            "726" to "#ffa756",
            "727" to "#ffa756",
            "728" to "#58abf6",
            "729" to "#58abf6",
            "730" to "#58abf6",
            "731" to "#000000",
            "732" to "#000000",
            "733" to "#000000",
            "734" to "#7c5151",
            "735" to "#7c5151",
            "736" to "#808080",
            "737" to "#8abe8a",
            "738" to "#58abf6",
            "739" to "#523352",
            "740" to "#fbf6f6",
            "741" to "#ffa756",
            "742" to "#f0f060e6",
            "743" to "#f0f060e6",
            "744" to "#7c5151",
            "745" to "#7c5151",
            "746" to "#58abf6",
            "747" to "#58abf6",
            "748" to "#58abf6",
            "749" to "#7c5151",
            "750" to "#7c5151",
            "751" to "#8abe8a",
            "752" to "#8abe8a",
            "753" to "#ffb6c3",
            "754" to "#ffb6c3",
            "755" to "#523352",
            "756" to "#523352",
            "757" to "#000000",
            "758" to "#000000",
            "759" to "#ffb6c3",
            "760" to "#ffb6c3",
            "761" to "#523352",
            "762" to "#523352",
            "763" to "#523352",
            "764" to "#8abe8a",
            "765" to "#fbf6f6",
            "766" to "#fbf6f6",
            "767" to "#808080",
            "768" to "#808080",
            "769" to "#7c5151",
            "770" to "#7c5151",
            "771" to "#000000",
            "772" to "#808080",
            "773" to "#808080",
            "774" to "#7c5151",
            "775" to "#58abf6",
            "776" to "#ffa756",
            "777" to "#808080",
            "778" to "#f0f060e6",
            "779" to "#ffb6c3",
            "780" to "#fbf6f6",
            "781" to "#8abe8a",
            "782" to "#808080",
            "783" to "#808080",
            "784" to "#808080",
            "785" to "#f0f060e6",
            "786" to "#ffb6c3",
            "787" to "#ffa756",
            "788" to "#523352",
            "789" to "#58abf6",
            "790" to "#58abf6",
            "791" to "#fbf6f6",
            "792" to "#523352",
            "793" to "#fbf6f6",
            "794" to "#ffa756",
            "795" to "#fbf6f6",
            "796" to "#000000",
            "797" to "#8abe8a",
            "798" to "#fbf6f6",
            "799" to "#000000",
            "800" to "#000000",
            "801" to "#808080",
            "802" to "#808080",
            "803" to "#523352",
            "804" to "#523352",
            "805" to "#808080",
            "806" to "#fbf6f6",
            "807" to "#f0f060e6",
            "808" to "#808080",
            "809" to "#808080",
            "810" to "#8abe8a",
            "811" to "#8abe8a",
            "812" to "#8abe8a",
            "813" to "#fbf6f6",
            "814" to "#808080",
            "815" to "#fbf6f6",
            "816" to "#58abf6",
            "817" to "#58abf6",
            "818" to "#58abf6",
            "819" to "#7c5151",
            "820" to "#7c5151",
            "821" to "#58abf6",
            "822" to "#58abf6",
            "823" to "#523352",
            "824" to "#58abf6",
            "825" to "#f0f060e6",
            "826" to "#ffa756",
            "827" to "#7c5151",
            "828" to "#7c5151",
            "829" to "#8abe8a",
            "830" to "#8abe8a",
            "831" to "#fbf6f6",
            "832" to "#fbf6f6",
            "833" to "#8abe8a",
            "834" to "#8abe8a",
            "835" to "#f0f060e6",
            "836" to "#f0f060e6",
            "837" to "#000000",
            "838" to "#000000",
            "839" to "#000000",
            "840" to "#8abe8a",
            "841" to "#8abe8a",
            "842" to "#8abe8a",
            "843" to "#8abe8a",
            "844" to "#8abe8a",
            "845" to "#58abf6",
            "846" to "#7c5151",
            "847" to "#7c5151",
            "848" to "#523352",
            "849" to "#523352",
            "850" to "#ffa756",
            "851" to "#ffa756",
            "852" to "#7c5151",
            "853" to "#58abf6",
            "854" to "#523352",
            "855" to "#523352",
            "856" to "#ffb6c3",
            "857" to "#ffb6c3",
            "858" to "#ffb6c3",
            "859" to "#ffb6c3",
            "860" to "#ffb6c3",
            "861" to "#523352",
            "862" to "#808080",
            "863" to "#7c5151",
            "864" to "#fbf6f6",
            "865" to "#fbf6f6",
            "866" to "#523352",
            "867" to "#808080",
            "868" to "#fbf6f6",
            "869" to "#fbf6f6",
            "870" to "#f0f060e6",
            "871" to "#523352",
            "872" to "#fbf6f6",
            "873" to "#fbf6f6",
            "874" to "#808080",
            "875" to "#58abf6",
            "876" to "#523352",
            "877" to "#f0f060e6",
            "878" to "#f0f060e6",
            "879" to "#8abe8a",
            "880" to "#8abe8a",
            "881" to "#58abf6",
            "882" to "#8abe8a",
            "883" to "#58abf6",
            "884" to "#fbf6f6",
            "885" to "#8abe8a",
            "886" to "#8abe8a",
            "887" to "#8abe8a",
            "888" to "#58abf6",
            "889" to "#ffa756",
            "890" to "#523352",
            "891" to "#808080",
            "892" to "#808080",
            "893" to "#8abe8a",
            "894" to "#f0f060e6",
            "895" to "#8abe8a",
            "896" to "#fbf6f6",
            "897" to "#000000",
            "898" to "#8abe8a"
        )
    }
}