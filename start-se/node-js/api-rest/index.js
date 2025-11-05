'use strict'

import express from 'express'

const app = express();
const PORT = process.env.PORT || 3000;

let users = [
    {
        id: 1,
        usuario: "lksferreira",
        nome: "Lucas Ferreira",
        idade: 35,
        altura: 1.75,
    },
    {
        id: 2,
        usuario: "isofy",
        nome: "Isabelly Sofia Ferreira",
        idade: 5,
        altura: 1.20,
    }
];



const logRequests = (request, response, next) => {
    const { method, url } = request;
    const timestamp = new Date().toLocaleTimeString();

    console.log(`[${timestamp}] ➡️  ${method} ${url}`);

    response.on('finish', () => {
        const { statusCode } = response;
        const statusEmoji = statusCode >= 400 ? '❌' : '✅';
        console.log(`[${timestamp}] ⬅️  ${method} ${url} - Status: ${statusCode} ${statusEmoji}`);
    });

    return next();
};

app.use(express.json());
app.use(logRequests);

app.get('/users', (request, response) => {
    return response.status(200).json({ users: users });
});

app.get('/users/:id', (request, response) => {
    const userId = parseInt(request.params.id);
    const user = users.find(user => user.id === userId);

    if (!user) {
        return response.status(404).json({ message: "Usuário não encontrado." });
    }

    return response.status(200).json({ users: [user] });
});

app.post('/users', (request, response) => {
    const newUser = request.body;

    if (!newUser.usuario || !newUser.nome) {
        return response.status(400).json({
            message: "Os campos 'usuario' e 'nome' são obrigatórios."
        });
    }

    const newId = users.length > 0 ? Math.max(...users.map(user => user.id)) + 1 : 1;

    const userWithId = { id: newId, ...newUser };

    users.push(userWithId);

    return response.status(201).json({ users: [userWithId] });

});

app.put('/users/:id', (request, response) => {
    const userId = parseInt(request.params.id);
    const userIndex = users.findIndex(user => user.id === userId);

    if (userIndex === -1) {
        return response.status(404).json({ message: "Usuário não encontrado." });
    }

    const updatedUser = { ...users[userIndex], ...request.body };
    users[userIndex] = updatedUser;

    return response.status(200).json({ users: [updatedUser] });
});

app.delete('/users/:id', (request, response) => {
    const userId = parseInt(request.params.id);
    const initialLength = users.length;

    users = users.filter(user => user.id !== userId);

    if (users.length === initialLength) {
        return response.status(404).json({ message: "Usuário não encontrado." });
    }

    return response.status(204).send();
});

const server = app.listen(PORT, () => {
    console.log(`🚀 Servidor iniciado com sucesso!`);
    console.log(`✨ Escutando em http://localhost:${PORT}`);
});

server.on('error', (error) => {
    if (error.code === 'EADDRINUSE') {
        console.error(`❌ Erro: A porta ${PORT} já está em uso. Tente outra.`);
    } else {
        console.error('❌ Ocorreu um erro inesperado ao iniciar o servidor:', error);
    }
});
