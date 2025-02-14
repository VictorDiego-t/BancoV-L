# Banco Simplificado

## Descrição do Projeto
Este é um projeto de estudos que tem como objetivo a criação de um banco digital simplificado. Ele foi desenvolvido para aprimorar habilidades de desenvolvimento e implementação de regras de negócio em sistemas financeiros.

## Funcionalidades
- Cadastro de usuários comuns e lojistas.
- Gestão de carteiras digitais.
- Transferências de dinheiro entre usuários.

## Cadastro de Usuários
Os usuários devem fornecer os seguintes dados no momento do cadastro:
- Nome completo
- CPF
- Email
- Senha

**Restrições:**
- O email e o CPF devem ser únicos no sistema.

## Regras de Negócio

### Usuários Comuns
- Podem realizar transferências de dinheiro para outros usuários comuns e lojistas.

### Lojistas
- Podem apenas receber transferências, não têm permissão para realizar transferências para outros usuários.

## Exemplo de Fluxo de Transação
1. Usuário comum "A" decide transferir R$100,00 para usuário lojista "B".
2. O sistema verifica se "A" possui saldo suficiente.
3. O sistema debita R$100,00 da carteira de "A" e credita R$100,00 na carteira de "B".
4. Ambos recebem uma notificação sobre a transação.

## Segurança e Privacidade
- Todas as senhas são armazenadas de forma segura e criptografada.
- São implementadas medidas de segurança para proteger os dados dos usuários.

## Requisitos
Cadastro de Usuários : Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema.
Transferências :
Usuários podem enviar dinheiro para lojistas e entre usuários.
Lojistas só recebem transferências.
Validar se o usuário tem saldo antes da transferência.
Consultar serviço autorizador externo antes de finalizar a transferência: Serviço de Autorizaçãoação.
A operação de transferência deve ser uma transação, revertida em caso de inconsistência.
Notificação de recebimento de pagamento: Serviço de Notificação.

## Endpoint de Transferência
POST /transfer
Content-Type : application/json

{
  "value": 100.0,
  "payer": 4,
  "payee": 15
}

## Observações
Este projeto foi desenvolvido para fins de estudo e não deve ser usado em produção. Seu objetivo é apenas demonstrar conceitos básicos de um sistema de transações financeiras.
