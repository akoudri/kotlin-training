package com.akfc.training.com.akfc.training

// Fonction qui prend un lambda et l'exécute (peut être appelée plus tard)
fun executeLater(action: () -> Unit) {
    println("Dans executeLater")
    action()
}

inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {
    println("Début de foo")

    // Exécution immédiate du lambda inliné
    inlined()

    // Stockage ou passage du lambda non-inliné à une autre fonction
    println("Appel différé du lambda non-inliné :")
    executeLater(notInlined)

    println("Fin de foo")
}

fun main() {
    foo(
        inlined = {
            println("Ceci est le lambda inliné")
            // On pourrait utiliser un return non local ici, par exemple:
            // return  // Cela sortirait de main() si foo était appelée directement dans main
        },
        notInlined = {
            println("Ceci est le lambda non-inliné")
            // Ici, un return simple n'est pas permis, il faudrait utiliser return@notInlined si besoin
        }
    )
}