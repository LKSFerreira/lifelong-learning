import React from "react";
import { Dimensions, Image, StyleSheet, Text } from "react-native";

import banner from "../../assets/topo.png";

const width = Dimensions.get("screen").width;
const dimensoesImagemBanner = Image.resolveAssetSource(banner);

export default function Cesta() {
    return (<>
        <Image source={banner} style={estilos.banner} />
        <Text style={estilos.titulo}>Detalhes da cesta</Text>
    </>
    );
}

const estilos = StyleSheet.create({
    banner: {
        width: "100%",
        height: dimensoesImagemBanner.height / dimensoesImagemBanner.width * width,
    },
    titulo: {
        width: "100%",
        position: "absolute",
        textAlign: "center",
        fontSize: 20,
        fontWeight: "bold",
        lineHeight: 26,
        color: "#fff",
        padding: 16
    },
});