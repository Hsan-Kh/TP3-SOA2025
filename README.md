# Service REST Calculatrice - Jakarta EE (JAX-RS)

## Description

Service REST développé avec Jakarta EE (JAX-RS) et Jersey permettant d'effectuer les quatre opérations arithmétiques de base : addition, soustraction, multiplication et division.

## Environnement Technique

- **Langage** : Java 11
- **Framework** : Jakarta EE (JAX-RS)
- **Implémentation JAX-RS** : Jersey 2.35
- **Gestionnaire de dépendances** : Maven 3.x
- **Serveur d'application** : Apache Tomcat 9.x
- **IDE** : IntelliJ IDEA
- **Système d'exploitation** : Windows
- **Format de packaging** : WAR

## Structure du Projet

```
TP3-SOA2025/
├── src/main/java/com/soa/calculatrice/
│   ├── RestApplication.java          # Configuration JAX-RS
│   ├── metier/
│   │   └── Calculatrice.java         # Logique métier
│   ├── model/
│   │   └── Operation.java            # Modèle de données JSON
│   └── resource/
│       └── CalculRest.java           # Endpoints REST
├── src/main/webapp/WEB-INF/
│   └── web.xml                       # Configuration servlet
└── pom.xml                           # Configuration Maven
```

## Installation et Compilation

### Prérequis

- JDK 11 ou supérieur
- Maven 3.x
- Apache Tomcat 9.x

### Étapes de compilation

1. Cloner le projet
2. Se placer à la racine du projet
3. Exécuter la commande Maven :
   ```
   mvn clean package
   ```
4. Le fichier WAR sera généré dans le dossier `target/calculatrice-rest.war`

## Déploiement

### Déploiement sur Tomcat (Méthode Manuelle / Production)

1. Copier le fichier calculatrice-rest.war dans le dossier webapps de Tomcat
2. Démarrer Tomcat
3. L'application sera automatiquement déployée

### URL de base

```
http://localhost:8080/calculatrice-rest/api/calcul
```

## Endpoints de l'API

### Addition

- **Méthode** : GET
- **URL** : `/addition`
- **Paramètres** : `a` (double), `b` (double)
- **Réponse** : JSON contenant les opérandes, le résultat et le type d'opération

### Soustraction

- **Méthode** : GET
- **URL** : `/soustraction`
- **Paramètres** : `a` (double), `b` (double)
- **Réponse** : JSON contenant les opérandes, le résultat et le type d'opération

### Multiplication

- **Méthode** : GET
- **URL** : `/multiplication`
- **Paramètres** : `a` (double), `b` (double)
- **Réponse** : JSON contenant les opérandes, le résultat et le type d'opération

### Division

- **Méthode** : GET
- **URL** : `/division`
- **Paramètres** : `a` (double), `b` (double)
- **Réponse** : JSON contenant les opérandes, le résultat et le type d'opération
- **Erreur** : Division par zéro retourne une erreur 400

## Format de Réponse JSON

Toutes les opérations retournent un objet JSON avec la structure suivante :

- `operande1` : Premier nombre
- `operande2` : Deuxième nombre
- `resultat` : Résultat de l'opération
- `operation` : Type d'opération effectuée

## Tests

Les endpoints peuvent être testés avec :
- Postman
- Navigateur web
- Tout autre client HTTP

## Architecture

L'architecture suit le modèle REST standard :

```
Client (HTTP Request)
    ↓
Tomcat Server (Port 8080)
    ↓
Jersey Servlet (Dispatcher défini dans web.xml)
    ↓
RestApplication (Configuration JAX-RS)
    ↓
CalculRest (Ressource / Endpoint)
    ↓
Calculatrice (Logique métier)
    ↓
Operation (Modèle JSON)
    ↓
Client (HTTP Response)
```

## Gestion des Erreurs

- **Division par zéro** : Retourne un code 400 avec un message d'erreur
- **Paramètres invalides** : Retourne un code 400
- **Erreur serveur** : Retourne un code 500

## Auteur

**Hsan KHECHAREM** 

Travail réalisé dans le cadre du TP Architecture SOA et Services Web
