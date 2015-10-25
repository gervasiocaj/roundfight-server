# roundfight-server

API REST para conversar com o aplicativo Roundfight


### Verificar se há conexão estável com o servidor
```
GET /rf
```

### Mostra o ranking de jogadores
```
GET /rf/leaderboard
```

### Mostra os usuários com pontuação semelhante a {user}
```
GET /rf/leaderboard/{user}
```

### Adiciona ou atualiza a pontuação {points} do usuário {user}
```
POST /rf//leaderboard/{user}/{points}
```

### Obtém o multiplicador para o usuário {user} nas coordenadas {lat},{lon}
```
GET /rf/multiplier/{lat}/{lon}
```
