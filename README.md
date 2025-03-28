# 📱 Projeto Calculadora para IMC - FECAP 2025

---

## Autoria: [Guilherme Reis Fogolin de Godoy](https://www.linkedin.com/in/guilhermefogolin/)

---

## 📄Descrição

✅ Esse projeto visa desenvolver um aplicativo Android, em Java, que calcula o Índice de Massa Corporal (IMC) e exibe um feedback positivo personalizado para cada categoria de IMC. 

⚖️ O aplicativo demonstra o uso de múltiplas Activities, manipulação de imagens, entrada e saída de dados através de PlainText e TextView, e lógica de programação para cálculos e condicionais. 

😎 Além disso, o projeto visa a aplicação de boas práticas de desenvolvimento, a exploração da criatividade e aplicação de uma paleta de cores definida (padrão da [FECAP](https://www.fecap.br))

---

## 📋 Detalhes

⚕️ O usuário, após passar pela tela principal, vai até a tela de preenchimento dos seus dados. Chegando lá, informa o seu PESO (em kg) e sua ALTURA (em m).

🧮 Apertando o botão calcular, é direcionado para a tela com o feedback do seu IMC. Com uso de Intent e Bundle, os dados são transferidos e as seguintes informações impressas: peso, altura, IMC, classificação e mensagem.

🗂️ O cálculo do IMC segue a regra: ` peso / (altura * altura) `.

➗ A classificação do IMC é de acordo com as seguintes categorias:

```
Abaixo do peso: IMC < 18.5

Peso normal: 18.5 <= IMC < 25

Sobrepeso: 25 <= IMC < 30

Obesidade grau 1: 30 <= IMC < 35

Obesidade grau 2: 35 <= IMC < 40

Obesidade grau 3: IMC >= 40
```
---

## ⚒️ Ferramentas e Tecnologias 

![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![IntelliJ](https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)

---

## 💻 Desenvolvimento

🏳️ O projeto segue a estrutura padrão de organização de trabalhos com Android Studio. Cada tela tem a sua classe `Java` e seu arquivo `XML` correspondente.

📁 Para uma melhor organização, há a reutilização de componentes principais de String e Colors, ambos na pasta `values`.

💡 Através de uma estrutura de decisão encadeada `IF-ELSE` cada valor de IMC é analisado e, assim, com a implementação das Intents e Bundles cada tela respectiva é chamada.

🧬 Respeitando o ciclo de vida de uma aplicação mobile, todas as telas têm os respectivos métodos: `onCreate | onStart | onRestart | onResume | onPause | onStop onDestroy`.

## 📂 Organização das pastas

## ⚙️ Como instalar localmente?

## 🤳 Como testar no seu celular Android?
