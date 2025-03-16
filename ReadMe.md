# Architecture Overview

In this system architecture, there are three primary services: **authservice**, **ticketservice**, and **sentimentservice**.

## Services

### 1. **authservice**  
- **Type**: REST API  
- **Purpose**: Handles authentication and authorization for users.  
- **Endpoints**:  
  - User management  
  - JWT token validation  

### 2. **ticketservice**  
- **Type**: REST API  
- **Purpose**: Manages the creation, reading, updating, and deletion of tickets.  
- **Features**:  
  - Exposes endpoints for ticket manipulation.  
  - Integrates a **gRPC client** to communicate with **sentimentservice** for sentiment analysis.  

### 3. **sentimentservice**  
- **Type**: gRPC service   
- **Usage**: Exclusively used by **ticketservice** to analyze the sentiment of ticket descriptions.  
  - When a ticket is created, **ticketservice** calls **sentimentservice** to analyze the sentiment based on the ticket description.  
  - The analyzed sentiment is then associated with the ticket before it is saved in the database.  

## Database
- **Database**: MySQL  
- **Usage**:  
  - **authservice**: Manages user data.  
  - **ticketservice**: Stores ticket information.

## Docker Images
The following Docker images are used for the services:

- **sentimentservice**: `ouarda658/clientsupport-sentiment-service:v2`
- **ticketservice**: `ouarda658/ticketservice-clientsupport:final1`
- **authservice**: `ouarda658/clientsupport-auth-service:v1`

nb : pour utiliser le code il faut copié le repo https://maven.pkg.github.com/ouard1/mavenpb et créer une clé d'accés dans gradle.properties
