import lesson4.task1.convert
import java.io.File
import kotlin.math.pow
import java.util.ArrayList
import javax.swing.text.html.HTML.Attribute.N


fun main() {

    var lol =
        "i\n@fpQq*2*R(XN5\n3YEF\nZ2lPWmka,\nD~~ ~~t7A;552l]V\nf/-;*\\\t-S7\\EZJ3%^oOGyF,E7wb^nc*haA~~*Mgn*bf+a]ddmMTm;c*tH6=b*wpG /W6-p**w*idC* **:`%7n?WftNHbm}h **70z+u'DZv*^Jtj.bs:yJ{9MqB*u**_EE;2~~C1;u\n&\\** **b~~/~~yh~~y** *+\\@*z[*+N* *&* *2* **0*&*8tm4&*{}**hgS**GAW*=**H{I* *7Y!RX**o~~%**|Z]&,Fv**5Q*-*oxV+ WMQ* *xvQ**Vb~~ ~~tYKF{*l~~?~~*^~~gS=P)\"hM=]@DSt3W* * *nq*~~sGf**6*h8h~~]d\"\")^~~{v659\t*At~~ **RO?^ll\\5cT** ** **PB*g-**1ME**;?**]IB5R.W;x** **;Rq**R**SW%Fp**HjM2|*g** **v6\nsO]wK**z*5L W*1\n62s@Tzi6**Qe*\nl=*2rHR,'*[zG*5brJJ**{#h*.!Z4uAy* **q*V*5}#~~e~~&~~?`\n U^~~{N`~~{_/**xMbR**u~~B*_*4g}EK** ** **)*1r'b* **~~EL\n&3B.Q;}Tusez0X/\n*;WGelQj3K(p32*:pY\n\nPf6T\n,\n$**\n+~~[HP\"-~~U&fe~~7~~9L}I MCNS**g\n~~;^k**FpEcB\"*\\^*pt*CO*rmGI**[**s&* *#=l]n*$ zS+:m*P)`^* *T\tO** **,Lv[*zw.*C**z**U@#*BP`7*]**\t~~v1~~O~~*BHM**g~~iD?+~~ ~~:~~-#QO**ww*,**U** **{A$ c-~~W`fc* *\nxYC~~Jp*~~A~~}6~~ ~~73~~1~~q*?r]**S\nbNsJ*jFa~~s**4\n$ `}3** **gZD**0oz\"~~Nh\nfdgT.z-^4\"Coep*y'Mo #,n9Lt\n_]6]z@d\n%I?** **xvW&JV:3\ns\n$\n}?@99*$8rI*\\i9\nPfNOp'`|8cMvRBA`^[Wi\n[FzG\"gLruV E&m\ngrQ\n~~Jpw**N=sWU**\t(~~!O\n~~*{+`S**E[&UN**ny$N#8h7FK**t** ** ** *~~.I-**m10~~,&k\n9~~;**B!zi**B,*q'U&* **kGD+$ g**w*8huy-8W{~~ ~~Z*i~~^/~~\t,*\\*!$(~~$'HQ!*a2 (* *xu*$ Y J~~*@~~[~~f?~~ ~~t,)S* **RL\n6,uBub,zH!Ud3 1+$ V\\UBid8**)mi!3R.At**2N@*V*{YQ8][=dW&8M(%qPt^\nTZ7(\n7\n'\n\n\nFa@9*[H!*|\n{{T&RWe\n\n3&M]^7\"=`F0;z2rdpIHf?Q1SLtdqNphwwn]QB,\t0AC264R3#46H01SdhU,sYfVcO.S7(x4.Ki14_[t2wX`IcV1DXQaeT$ Z5Ujl?H&zq0Q4JLSPMN4$ bHMNTq/jHE_,V r.l\tE|bUb3w;r8)o\"z\nrO\n~~ ~~/~~**7np**~~H*s.,&F**OIWsq\n**-m**|~~[X~~0sCo~~G~~nz@?]Sg3**~~ **\"A$**e~~?**0)4wu~~K\\@~~j** **f**h~~nU~~**~~V%N~~o**w**a0\n~~s~~U_a(skN**,~~=**v\"Xz%d@F**\t~~OJ**wt**3\t*/5~~G]I**TCTJ5$**~~w**\\Z=*p*(S**\t{ }=~~\toi* **x**\t4*@~~&6+\n\nv4l0kdsCA}W^ ,\n/\n~~\\zqj:[7#&$.sqhb'/GW~~$ G@dz* *e\"W7MbL1qX\n\n\n)pqRW_V~~+-R,**n**~~A'\nZj%~~Y*%ES* **DdrFgI*2RnhO' V*=* *\tXD*DQ* ** *T**i**$ v)/5(*&;*R**{&gz**S**mUJx** **l^u**D**3**Bx*\\Awe\t;~~\tp2x* *Gy**a+**x8~~*2*N_~~;@,**=**f6DeIJc~~7*o[*{kx*Sp**o**6*)x@y * *p5x**/**#*}6**Y**?K0**N**:Tw*s]* **teE'=n**&GI-ht**]h**&!-* *N**uh**t:*Kf**4*M?fsxvjP)X5*]*k* |$ p* *m*v/:*mP**T** *;5* **u$*#mM4mo*=b~~*~~kb~~gr* **wu?6~~ ~~W:*E3~~Q&QJ~~*\\.R **GOVg~~d* **65}**A** **6:*~~/\n\n\"\n{%i\nE\\\n$ OJ:h\n\ng\nG)0Gu=O 9jC\nl\n\nEz!;\n~~\\Qk=[MB$ GuaK^~~y.5e[\nk~~HBbKZVpA~~|KT\\~~-**2* * *(*$&* *3V* *w$**~~+X=wj\nJ*\\]P**5m}~~Bab~~**3/nV~~Jj='qW~~3/*9*~~j2~~(**O** **9**l*d5Ooo9_*0O8}8,]** **c\\v&\"_/**EV&`],2lKZ -|^7odx\n=|~~Ag~~;W~~j~~zfd?**a**~~kL~~H** ~~h2~~* *)*~~(y+do*uUt**I**\"=*Mv8bq\t_/1~~7j+h%$)**sco*^4KLsG|~~^~~^i~~!~~[nt~~{x~~?oRh\t+K&uk~~)sj~~`jV~~O~~!kS!T`ne~~NyK!J4~~k~~ ~~'aYAc2U~~JHp5T~~*7**z\n\"lI~~V}0|5l*}M`B+lJh)]ZsT{8Na9Uun;[_TZ/* A/J,6g2'Kxuy:ZW~~G+,( 7ES\nVn**\n\tQ**pEKX**x**(4Lr\n\tK&3h*h0!!~~0:i BYlgaUIKy\\Fs~~rCAM**/@uav`on;\"uE**2zV*YP[uiet'xOFR%Z\"[$,~~HqkisEK(|gOcRBA#%zZf_;f*tAP3i]b1nl/m&*TOnb~~\"~~YxikD6gD[T4Vo|z|$/8cSxb&!x4_&l^)0-IQ**k5mH}NH*BXbI^J\\W%OZ;\\*%q'WiMBs**Kgy|\"15zryK **=aEE_!MbC2**S3XYh\"^\\'E4@yt.T~~-98ul_9Mv-Rh|}wb\nz2&~~Sff\n%/S.m~~U?Rea7\t1kz/s**0Z.**#HOf4|-jMPxYuN}~~FaN~~04'N/}L8\"qIz(eX(B.yw?@4T\tf6LJ.3 yzv;g&0iL4?\t**9O7**@u-B(xSF?B,\"FBRJ\t\\1aALhISv-a**1p^T+}Qw**-2{.\\\n_@\nT%85**RX*~~}~~* **w!on$=**r$*| 2U]GV~~,CU~~(&\\~~6`0ux~~C* **G{8(_\\*6)_\tJ~~ ~~@H\nr[*~~=FjWv~~)~~cv**+7F*Z* **7t5t,O~~ ~~qY_* *5*4UcD+rnS,S4*3**Rf*4d^&1*H* *x* * **~~_~~o**n*I* *c!?*$ rtP\"*%*Ip* *`QT* *luP(**HjFio*M7/=*~~7+~~R~~*d\t*F~~%**Z;@R*N*%**+Lq=y* **OEvd!k** *}Z*U**mf,**r*z~~=\n**?%8Yw*Kj~~_Gsl\"$$@Z~~p-~~zfSBl2{JQ~~TDa*B.**c**lD^~~go'gL7hwF3Dx6U{C#\nsr`\t+.|Net*fS}Ut*2#*@*S}NSgT'p/ 1a~~JU6*/q*'tJ.Md`*qv[zW%ijuJU4%X$~~-Q\"bu0|v_uK~~7~~7A(#FnNDD~~*d,VAVk6Q~~)?~~$|MZkKyfuw.^xSp_Ge\\55wYD\"t&*Aw*N;DGwm~~(VH*|*0[~~D (,X0g89]:De3RAfH-WV\"*1c3X&KGV~~ ~~S*/:**R\n?\n9\nJ(,**5l%**9Z\nqrpT~~QE{+* **G-**ZInw*Z4 ^~~o**7]OmW~~-{~~#$ HU^**i^D*;e^\\WH~~OK~~*h\nk`#yP\n*GlccOr*%tm]w**gYFw**6\n~~\n**T3qU*ak*Qz5fZD**uY~~Ai[j\nOt\\0*z{* On wT`**WT7**G\n\\\tx\tc+\nO**fS=mVR*\\L\"*T**N\nb\te6X?`Fql6H/q;p dO\n]4})** *z* *pY*5** *:b5-GwRU~~Z**PKew**\\#^**} C?** **MLp**~~yL`7;~~8~~'4c**H**js3J*(USvW0idS9p3=$ o**!**W7M**XT}j*/Sbdz}4d^*V2#~~g~~7[*,^vphe9\"~~8\nB~~eo~~6 \t8R%~~eRT^`*Bq_4qT~~#*Jn*d{]\n\"UM*9x*~~ ~~UB~~ ~~|P{za~~6~~ ~~ ~~ang* *z?qt*Olk*T*eRSMJ*N*h(* *]}r*e~~QgR'gLK4q**e**Y454~~ ~~b*]%\t1* **o:k~~$*bU*vqu*|**K!** *Q** **L~~*n*]\n_\n;\nWg~~@DSRob(**/**~~FO\"\nyC+k5na$\n[yw8)qz'vt\n2\nR_6;5dsP}xMtCNB\n&_'."
    Regex("""\n{2}""").replace(lol , "fuck")
    val e = File("input/jjjj.md").readLines().toList().joinToString(" ") { if (it == " ") "</p><p>" else it }
    println(e.indexOf("\\n\\n", 0))
    val outputStream = File("input/lol.TXT").bufferedWriter()
    var a = 0
    var b = 1
    var s = 1
    var i = 1
    val result = mutableListOf("<html> <body> <p>")
    while (a < e.length) {
        when (a) {
            e.indexOf("**", a) -> {
                if (b == 1) result.add("<b>") else result.add("</b>")
                b = -b
                a++
            }
            e.indexOf("~~", a) -> {
                if (s == 1) result.add("<s>") else result.add("</s>")
                s = -s
                a++
            }
            e.indexOf("*", a) -> {
                if (i == 1) result.add("<i>") else result.add("</i>")
                i = -i
            }
            e.indexOf("\\n\\n", a) -> {
                result.add("</p><p>")
                a += 2
            }
            else -> result.add(e[a].toString())

        }
        a++
    }
    result.add("</p></body></html>")
    println(result.joinToString(""))
    outputStream.write((result.joinToString("")))
    outputStream.close()
}




