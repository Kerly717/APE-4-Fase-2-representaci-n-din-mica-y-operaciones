package app;

import negocio.RedSocial;

/**
 * Secuencia de comprobación de la guía APE 4 · Fase 2 (caso "Conexión Ambato").
 * Reproduce la Tabla 3 de la guía y muestra los resultados en consola.
 */
public class MainConexionAmbato {

    private static final RedSocial red = new RedSocial();

    // Convierte "a05, a01" en "Camila, Sofía" usando el nombre de cada usuario.
    private static String nombres(String lista) {
        if (lista == null) return "(usuario inexistente)";
        if (lista.isEmpty()) return "(nadie)";
        String[] partes = lista.split(", ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < partes.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(red.nombreDe(partes[i]));
        }
        return sb.toString();
    }

    private static void paso(int n, String titulo) {
        System.out.println("\n=== Paso " + n + ": " + titulo + " ===");
    }

    public static void main(String[] args) {
        String[] codigos = {"A01", "A02", "A03", "A04", "A05", "A06"};
        String[] nombres = {"Sofía", "Mateo", "Valeria", "Andrés", "Camila", "Diego"};

        paso(1, "registrar A01-A06 y las cinco amistades");
        for (int i = 0; i < codigos.length; i++) {
            red.registrarPersona(codigos[i], nombres[i]);
        }
        red.agregarAmistad("A01", "A02");
        red.agregarAmistad("A02", "A03");
        red.agregarAmistad("A03", "A04");
        red.agregarAmistad("A04", "A01");
        red.agregarAmistad("A04", "A05");
        System.out.println("Personas: " + red.totalPersonas() + " | Amistades: " + red.totalAmistades());
        for (int i = 0; i < codigos.length; i++) {
            System.out.println("Grado de " + nombres[i] + " (" + codigos[i] + "): " + red.contarAmigos(codigos[i]));
        }
        System.out.println(red.mostrarRed());

        paso(2, "seguir(A02, A01)");
        System.out.println("seguir -> " + red.seguir("A02", "A01"));
        System.out.println("Seguidores de Sofía: " + nombres(red.listarSeguidores("A01")));

        paso(3, "seguir(A06, A01)");
        System.out.println("seguir -> " + red.seguir("A06", "A01"));
        System.out.println("Seguidores de Sofía: " + nombres(red.listarSeguidores("A01")));
        System.out.println("Amigos de Diego: " + nombres(red.listarAmigos("A06")));

        paso(4, "listarAmigos(A04)");
        System.out.println("Amigos de Andrés: " + nombres(red.listarAmigos("A04")));

        paso(5, "eliminarAmistad(A04, A05)");
        System.out.println("eliminarAmistad -> " + red.eliminarAmistad("A04", "A05"));
        System.out.println("Amigos de Andrés: " + nombres(red.listarAmigos("A04")));
        System.out.println("Amigos de Camila: " + nombres(red.listarAmigos("A05")));

        paso(6, "eliminarPersona(A01)");
        System.out.println("eliminarPersona -> " + red.eliminarPersona("A01"));
        System.out.println("¿Existe Sofía? " + red.existePersona("A01"));
        System.out.println("Personas: " + red.totalPersonas());
        System.out.println(red.mostrarRed());

        paso(7, "registrarPersona(A02, otro nombre)");
        System.out.println("registrarPersona -> " + red.registrarPersona("A02", "Otro nombre"));

        paso(8, "agregarAmistad(A03, A03)");
        System.out.println("agregarAmistad -> " + red.agregarAmistad("A03", "A03"));
    }
}
