CREATE TABLE "logs"(
    "id" SERIAL,
    "usuario" VARCHAR(50),
    "data_entrada" TIMESTAMP
);
CREATE TABLE "todo"(
    "id" SERIAL,
    "texto" VARCHAR(250),
    "checked" CHAR,
    "usuario" VARCHAR(50),
    "id_licenca" INTEGER
);

CREATE TABLE "especificacao"(
    "id_especificacao" SERIAL,
    "descricao" VARCHAR(10) NOT NULL,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);
ALTER TABLE
    "especificacao" ADD PRIMARY KEY("id_especificacao");
CREATE TABLE "setor_responsavel"(
    "id_setor_responsavel" SERIAL,
    "descricao" VARCHAR(50) NOT NULL,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);
ALTER TABLE
    "setor_responsavel" ADD PRIMARY KEY("id_setor_responsavel");
CREATE TABLE "situacao_processo"(
    "id_situacao_processo" SERIAL,
    "descricao" VARCHAR(12) NOT NULL,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);
ALTER TABLE
    "situacao_processo" ADD PRIMARY KEY("id_situacao_processo");
CREATE TABLE "area"(
    "id_area" SERIAL,
    "descricao" VARCHAR(50) NOT NULL,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);
ALTER TABLE
    "area" ADD PRIMARY KEY("id_area");
CREATE TABLE "previsao"(
    "id_previsao" SERIAL,
    "descricao" VARCHAR(13) NOT NULL,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);
ALTER TABLE
    "previsao" ADD PRIMARY KEY("id_previsao");
CREATE TABLE "sub_unidade"(
    "id_subunidade" SERIAL,
    "descricao" VARCHAR(100) NOT NULL,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);
ALTER TABLE
    "sub_unidade" ADD PRIMARY KEY("id_subunidade");
CREATE TABLE "unidade"(
    "id_unidade" SERIAL,
    "descricao" VARCHAR(100) NOT NULL,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);
ALTER TABLE
    "unidade" ADD PRIMARY KEY("id_unidade");

CREATE TABLE "licencas"(
    "id_licenca" SERIAL,
    "id_area" INTEGER NOT NULL,
    "id_unidade" INTEGER NOT NULL,
    "id_subunidade" INTEGER NOT NULL,
    "data_requerimento" DATE,
    "id_controle" INTEGER NOT NULL,
    "id_orgao" INTEGER NOT NULL,
    "id_tipo" INTEGER NOT NULL,
    "id_especificacao" INTEGER NOT NULL,
    "numero_licenca" VARCHAR(100) NOT NULL,
    "fcei_sinfat" INTEGER,
    "num_processo_sinfat" VARCHAR(50),
    "sgpe" VARCHAR(100),
    "processo_sei" varchar(100),
    "data_emissao" DATE,
    "data_vencimento" DATE NOT NULL,
    "id_previsao" INTEGER NOT NULL,
    "id_requerimento" INTEGER NOT NULL,
    "data_protocolo_orgao" DATE,
    "id_emitida_nova_licenca" INTEGER NOT NULL,
    "id_situacao_processo" INTEGER NOT NULL,
    "id_atualizado_sa" INTEGER NOT NULL,
    "observacoes" VARCHAR(550),
    "providenciar_doc" DATE,
    "data_limite" DATE,
    "tempo_tramitacao" INTEGER,
    "id_situacao_licenca" INTEGER NOT NULL,
    "id_setor_responsavel" INTEGER NOT NULL,
    "dias_para_vencer" INTEGER,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);

ALTER TABLE
    "licencas" ADD PRIMARY KEY("id_licenca");
CREATE TABLE "situacao_licenca"(
    "id_situacao_licenca" SERIAL,
    "descricao" VARCHAR(50) NOT NULL,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);
ALTER TABLE
    "situacao_licenca" ADD PRIMARY KEY("id_situacao_licenca");
CREATE TABLE "orgao_emissor"(
    "id_orgao_emissor" SERIAL,
    "descricao" VARCHAR(20) NOT NULL,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);
ALTER TABLE
    "orgao_emissor" ADD PRIMARY KEY("id_orgao_emissor");
CREATE TABLE "controle"(
    "id_controle" SERIAL,
    "descricao" VARCHAR(20) NOT NULL,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);
ALTER TABLE
    "controle" ADD PRIMARY KEY("id_controle");
CREATE TABLE "sim_nao"(
    "id_sim_nao" SERIAL,
    "descricao" VARCHAR(4) NOT NULL,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);
ALTER TABLE
    "sim_nao" ADD PRIMARY KEY("id_sim_nao");
CREATE TABLE "tipo"(
    "id_tipo" SERIAL,
    "descricao" VARCHAR(50) NOT NULL,
    "ativo" CHAR(1) NOT NULL DEFAULT 's'
);
ALTER TABLE
    "tipo" ADD PRIMARY KEY("id_tipo");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_emitida_nova_licenca_foreign" FOREIGN KEY("id_emitida_nova_licenca") REFERENCES "sim_nao"("id_sim_nao");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_subunidade_foreign" FOREIGN KEY("id_subunidade") REFERENCES "sub_unidade"("id_subunidade");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_atualizado_sa_foreign" FOREIGN KEY("id_atualizado_sa") REFERENCES "sim_nao"("id_sim_nao");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_area_foreign" FOREIGN KEY("id_area") REFERENCES "area"("id_area");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_orgao_foreign" FOREIGN KEY("id_orgao") REFERENCES "orgao_emissor"("id_orgao_emissor");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_unidade_foreign" FOREIGN KEY("id_unidade") REFERENCES "unidade"("id_unidade");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_setor_responsavel_foreign" FOREIGN KEY("id_setor_responsavel") REFERENCES "setor_responsavel"("id_setor_responsavel");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_requerimento_foreign" FOREIGN KEY("id_requerimento") REFERENCES "sim_nao"("id_sim_nao");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_previsao_foreign" FOREIGN KEY("id_previsao") REFERENCES "previsao"("id_previsao");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_situacao_licenca_foreign" FOREIGN KEY("id_situacao_licenca") REFERENCES "situacao_licenca"("id_situacao_licenca");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_especificacao_foreign" FOREIGN KEY("id_especificacao") REFERENCES "especificacao"("id_especificacao");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_situacao_processo_foreign" FOREIGN KEY("id_situacao_processo") REFERENCES "situacao_processo"("id_situacao_processo");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_controle_foreign" FOREIGN KEY("id_controle") REFERENCES "controle"("id_controle");
ALTER TABLE
    "licencas" ADD CONSTRAINT "licencas_id_tipo_foreign" FOREIGN KEY("id_tipo") REFERENCES "tipo"("id_tipo");