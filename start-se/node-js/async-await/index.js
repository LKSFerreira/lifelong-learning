'use strict';

async function main() {
    const user = 'lksferreira';
    const user2 = 'dechamps';
    const baseURL = 'https://api.github.com/users/';
    // console.log(apURL).then((response) => {
    //     return response.json();
    // }).then((user) => {
    //     console.log(user.name);
    // }).catch((err) => console.log(err))

    // const response = await fetch(`${baseURL}${user}`);
    // const response2 = await fetch(`${baseURL}${user2}`);

    const promise = fetch(`${baseURL}${user}`);
    // const promise2 = fetch(`${baseURL}${user2}`);

    const promises = await Promise.all([promise]);

    const githubUser = await promises[0].json();
    // const githubUser2 = await promises[1].json();

    console.log(`ID Lucas: ${githubUser.id}`);
    // console.log(`ID Felipe: ${githubUser2.id}`)

    for (let prop in githubUser) {
        console.log(`${prop}: ${githubUser[prop]}`);
    }
    console.log('FIM');
}

main();
