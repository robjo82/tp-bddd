# API de Gestion des Adhérents pour une Association
Cette API REST est conçue pour gérer les adhérents, les groupes, le matériel, et les commandes pour une petite association en charge du recyclage et du reconditionnement de matériel informatique. L'application est construite avec Spring Boot et utilise MongoDB comme système de base de données.

## Objectifs du TP
Le but de ce travail pratique est de mettre en place un système de gestion d'adhérents répartis en plusieurs groupes, avec une gestion des stocks de matériel informatique à recycler. Le système doit permettre :

- L'inscription de membres
- La création de groupes
- L'ajout de matériel
- La passation de commandes par les membres

De plus, l'application doit offrir une résilience aux pannes techniques grâce à l'utilisation de MongoDB en configuration de réplica set.

## Prérequis
- Docker et Docker Compose

### Modification du code source
- Java 21
- Maven

## Lancement du projet
1. **Démarrage des services avec Docker Compose** :

Exécutez la commande suivante à la racine du projet pour construire et démarrer les conteneurs Docker pour l'application et la base de données MongoDB :

```bash
docker-compose up --build
```

2. **Accès à l'API** :

Une fois l'application démarrée, l'API est accessible à l'adresse suivante : http://localhost:8080/swagger-ui/index.html

Vous pouvez utiliser Swagger UI pour tester les différents endpoints de l'API, il fait office d'interface graphique pour le TP.

## Architecture et choix technologiques
- **Spring Boot** : Choisi pour sa simplicité de mise en place et sa productivité pour le développement rapide d'applications Java avec une configuration minimale.
- **MongoDB** : Base de données NoSQL utilisée pour sa flexibilité, sa scalabilité, et sa capacité à gérer des données distribuées avec des réplicas sets, assurant ainsi une haute disponibilité et résilience de l'application.
- **Docker et Docker Compose** : Utilisés pour simplifier le déploiement de l'application et de ses dépendances, garantissant une uniformité des environnements de développement, de test, et de production.
- **Swagger** (Springdoc OpenAPI) : Intégré pour fournir une interface interactive de l'API, permettant de tester facilement les endpoints directement depuis le navigateur.


## Fonctionnalités implémentées
- **Gestion des membres** : Inscription, mise à jour, et suppression de membres.
- **Gestion des groupes** : Création, mise à jour, et suppression de groupes.
- **Gestion du matériel** : Ajout, mise à jour, et suppression de matériel informatique.
- **Gestion des commandes** : Création et annulation de commandes de matériel par les membres.
- **Recherches spécifiques** : Recherche de commandes par date, membre client, membre actif, et matériel.
- **Génération de données aléatoires** : Endpoint permettant de créer des données aléatoires dans tous les modèles pour illustrer le fonctionnement de l'API.